package com.izerui.redis.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by serv on 2015/2/3.
 */
@RestController
public class MainController {

    @Autowired
    StringRedisTemplate redisTemplate;

    @RequestMapping("keys")
    public Set keys(){
        return redisTemplate.keys("*");
    }

}
