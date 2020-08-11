package com.imooc.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;


/**
 * @PACKAGE_NAME: com.imooc.config
 * @NAME: CorsConfig
 * @USER: code.rookie
 * @DATE: 2020/6/21
 * @TIME: 8:22 下午
 * @DAY_NAME_SHORT: 周日
 * @PROJECT_NAME: foodie-dev
 */
@Configuration
public class CorsConfig {
    public CorsConfig(){

    }
    @Bean
    public CorsFilter corsFilter(){
        //添加cors配置信息
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("http://localhost:8080");
        configuration.addAllowedOrigin("http://47.94.40.248:8080");
        configuration.addAllowedOrigin("http://47.94.40.248");
        configuration.addAllowedOrigin("http://www.topyin.cn:8080");
        configuration.addAllowedOrigin("http://www.shop.topyin.cn");
        configuration.addAllowedOrigin("http://www.center.topyin.cn");
        //设置是否发送cookie信息
        configuration.setAllowCredentials(true);
        //设置允许请求的方式
        configuration.addAllowedMethod("*");
        //设置允许的header
        configuration.addAllowedHeader("*");
        //url添加映射路径
        UrlBasedCorsConfigurationSource corsSource = new UrlBasedCorsConfigurationSource();
        corsSource.registerCorsConfiguration("/**",configuration);
        return new CorsFilter(corsSource);
    }
}
