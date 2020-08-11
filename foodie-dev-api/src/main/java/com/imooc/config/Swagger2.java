package com.imooc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    //访问地址：http://localhost:8088/swagger-ui.html
    //配置核心配置
    @Bean
    public Docket createRestApi(){
        //指定类型为Swagger2
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())                     //定义api文档信息
                .select()
                    .apis(RequestHandlerSelectors.basePackage("com.imooc.controller")) //指定Controller
                .paths(PathSelectors.any())   //所有contrller
                .build();


    }
    private ApiInfo apiInfo(){
        return  new ApiInfoBuilder()
                .title("没有名字")                       //文档也标题
                .contact(new Contact("没有名字",
                        "没有地址",
                        "没有邮箱"))               //联系人信息
                .description("为有个瞎jb写的提供api文档")  //描述
                .version("1.0.1")  //文档版本号
                .termsOfServiceUrl("这个是网站地址")     //网站地址
                .build();
    }

}
