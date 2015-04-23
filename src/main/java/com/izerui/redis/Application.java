package com.izerui.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by serv on 2015/1/24.
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties(RedisConfig.class)
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }

}
