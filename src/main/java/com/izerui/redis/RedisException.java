package com.izerui.redis;

/**
 * Created by serv on 2015/2/8.
 */
public class RedisException extends RuntimeException {

    public RedisException() {
    }

    public RedisException(String message) {
        super(message);
    }

    public RedisException(String message, Throwable cause) {
        super(message, cause);
    }
}
