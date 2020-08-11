package com.imooc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author lishun
 * @date 2020/6/15
 */
@SpringBootApplication
@MapperScan(basePackages = "com.imooc.mapper")
//扫描所有包以及相关组件包
@ComponentScan( basePackages = {"com.imooc","org.n3r.idworker"})
@EnableScheduling
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);

    }
}
