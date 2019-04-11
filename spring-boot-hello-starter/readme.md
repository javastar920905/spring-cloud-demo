# SpringBoot AutoConfiguration机制： 

    SpringBoot启动时，扫描 classpath 所有Jar中 META-INF/spring.factories文件，
    读取org.springframework.boot.autoconfigure.EnableAutoConfiguration 指定的Configuration，
    根据Configuration上的Conditional条件自动创建bean，注入容器。