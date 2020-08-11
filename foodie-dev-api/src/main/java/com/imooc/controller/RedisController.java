package com.imooc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author lishun
 * @date 2020/6/15
 */
@ApiIgnore
@RestController("redis")
public class RedisController {
    @Autowired
    private RedisTemplate redisTemplate;
    @GetMapping("/set")
    public String set(String key,String value){
        redisTemplate.opsForValue().set(key,value);
        return "0k";
    }
    @GetMapping("/get")
    public String get(String key){
        return(String) redisTemplate.opsForValue().get(key);
    }
    @GetMapping("/del")
    public String del(String key){
        redisTemplate.delete(key);
        return "ok";
    }

}
