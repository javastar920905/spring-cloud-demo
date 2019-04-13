package cn.javabus.alibabanacosconsume.feignfilter;

import com.alibaba.fastjson.JSONObject;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.stereotype.Component;

/**
 * 请求easyopen 接口时候携带 验证参数
 */
@Component
public class EasyOpenReqFilter implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {
        byte[] body = requestTemplate.body();
        System.out.println("請求數據body: "+new String(body));
        JSONObject param= JSONObject.parseObject(new String(body));

       requestTemplate.header( "Accept-Language" , "zh-CN");
        for (String key : param.keySet()) {
            requestTemplate.header(key, String.valueOf(param.get(key)));
        }
    }




}
