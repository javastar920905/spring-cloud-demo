package cn.javabus.alibabanacosconsume.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class EasyOpenUtil {
    static String appKey = "test";
    static String secret = "123456";

    private static DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Map buildParamMap(String urlName){
        return buildParamMap(urlName,null);
    }
    /**
     * 构建 easyopen 开放平台请求参数
     * @param urlName
     * @param reqData
     * @return
     */
    public static Map buildParamMap(String urlName,String reqData){
        String data=null;
        try {
            if (reqData!=null){
                data = URLEncoder.encode(reqData, "UTF-8");
            }else {
                data=URLEncoder.encode("{}", "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Map<String,String> paramsMap=new HashMap<>();
        paramsMap.put("name", urlName);
        paramsMap.put("access_token", "");
        paramsMap.put("version", "");
        paramsMap.put("app_key", appKey);
        paramsMap.put("data", data);
        paramsMap.put("format", "json");
        paramsMap.put("timestamp", format.format(new Date()));
        genSign(paramsMap);
        return paramsMap;
    }

    /**
     * easyopen 接口交互說明
     * https://durcframework.gitee.io/easyopen/#/files/108_%E6%8E%A5%E5%8F%A3%E4%BA%A4%E4%BA%92%E8%AF%A6%E8%A7%A3
     *
     * name:接口名称
     * version：接口版本号
     * app_key：分配给客户端的app_key
     * data：业务参数，json格式并且urlencode
     * format：返回格式，json,xml两种
     * timestamp：时间戳，yyyy-MM-dd HHmmss
     * sign：签名串
     * @return
     */
    public static void genSign(Map<String,String> paramsMap){
        Set<String> keySet = paramsMap.keySet();
        List<String> paramNames = new ArrayList<>(keySet);
        // 1.
        Collections.sort(paramNames);

        StringBuilder paramNameValue = new StringBuilder();
        // 2.
        for (String paramName : paramNames) {
            paramNameValue.append(paramName).append(paramsMap.get(paramName));
        }
        // 3.
        String source = secret + paramNameValue.toString() + secret;
        // 4.& 5.
        String sign =md5(source);
        // 6.
        paramsMap.put("sign",sign);
    }

    public static String md5(String source) {
        return DigestUtils.md5Hex(source).toUpperCase();
    }


    /**
     * 请求参数:
     * "access_token" -> ""
     * "app_key" -> "test"
     * "data" -> "%7B%7D"
     * "format" -> "json"
     * "name" -> "hello.get"
     * "version" -> ""
     * "timestamp" -> "2019-04-14 00:09:27"
     *
     * 期待加密结果:
     * "sign" -> "612E4615F05687E3CB4506A15685ECC0"
     */
    public static void main(String[] args) {

        try {
            Map<String,String> paramsMap=new HashMap<>();
            paramsMap.put("name", "hello.get");
            paramsMap.put("access_token", "");
            paramsMap.put("version", "");
            paramsMap.put("app_key", appKey);
            paramsMap.put("data", URLEncoder.encode("{}", "UTF-8"));
            paramsMap.put("format", "json");
            paramsMap.put("timestamp", "2019-04-14 00:09:27");
            genSign(paramsMap);


            System.out.println(JSON.toJSONString(paramsMap, SerializerFeature.PrettyFormat));

            System.out.println("612E4615F05687E3CB4506A15685ECC0".equals(paramsMap.get("sign")));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
