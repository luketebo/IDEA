package com.luketebo.configer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfiger {
    @Bean
    public Docket docket(){
        //题目：在生产环境中不使用swagger，测试环境中使用swagger
        //配置Swagger的Docket的Bean实例
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //RequestHandlerSelectors:配置要扫描接口的方式
                //basePackage:指定要扫描的包
                //any：扫描全部
                //none：不扫描
                //withClassAnnotation:扫描类上的注解，需要的参数是一个注解的反射对象
                .apis(RequestHandlerSelectors.basePackage("com.luketebo.controller"))
                //过滤什么路径
                //.paths(PathSelectors.ant("/joy/**"))
                .build();
    }

}