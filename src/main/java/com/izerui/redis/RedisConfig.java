package com.izerui.redis;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by serv on 2015/3/8.
 */
@ConfigurationProperties(prefix = "redis")
public class RedisConfig {

    private String locale;
    private String username;
    private String password;

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
