package cn.javabus.springcloudcommon.util;

//import springfox.documentation.builders.ParameterBuilder;
//import springfox.documentation.schema.ModelRef;
//import springfox.documentation.service.Parameter;

/**
 * @author ouzhx on 2018/9/26.
 */
public class SwaggerSettings {
    /**
     * 给每个swagger 接口添加token字段
     * @return
     */
//    public static List<Parameter> setHeaderToken() {
//        ParameterBuilder tokenParam = new ParameterBuilder();
//        List<Parameter> params = new ArrayList<>();
//        tokenParam.name("token").description("身份令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
//        params.add(tokenParam.build());
//        return params;
//    }


    /**
     * 使用参考
     *
     * @Configuration
     * @EnableSwagger2
     * public class SwaggerConfig {
     *     @Value("${spring.profiles.active}")
     *     private String profile;
     *
     *     @Bean
     *     public Docket platformApi() {
     *         boolean enable = !"prod".equalsIgnoreCase(profile);//正式环境关闭swagger
     *         return new Docket(DocumentationType.SWAGGER_2).enable(enable)
     *                 .apiInfo(apiInfo())
     *                 .select()
     *                 .apis(RequestHandlerSelectors.basePackage("cn.huacloud.tax.msg.controller")) // 注意修改此处的包名
     *                 .paths(PathSelectors.any())
     *                 .build().globalOperationParameters(SwaggerSettings.setHeaderToken());
     *     }
     *
     *     private ApiInfo apiInfo() {
     *         return new ApiInfoBuilder().title("企税易后台接口API").description("©2018 Copyright. Powered By hua-cloud")
     *                 .termsOfServiceUrl("http://172.17.6.115:8080/msg/swagger-ui.html") // 将“url”换成自己的ip:port
     *                 .contact("ouzx@hua-cloud.com.cn") // 无所谓（这里是作者的别称）
     *                 .version("1.1.0")
     *                 .build();
     *     }
     * }
     */
}
