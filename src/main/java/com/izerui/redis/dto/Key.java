package com.izerui.redis.dto;

import java.io.Serializable;

/**
 * Created by serv on 2015/2/8.
 */
public class Key implements Serializable {
    private String name;
    private String type;
    private long size;
    private long ttls;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getTtls() {
        return ttls;
    }

    public void setTtls(long ttls) {
        this.ttls = ttls;
    }
}
