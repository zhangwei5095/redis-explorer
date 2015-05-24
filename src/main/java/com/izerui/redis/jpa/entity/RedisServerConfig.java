package com.izerui.redis.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by serv on 2015/2/3.
 */
@Entity
public class RedisServerConfig implements Serializable{

    @Id
    private String id;
    private String displayName;
    private String host;
    private String password;
    private int port;
    @Column(updatable = false)
    private Date createTime;
    private Date updateTime;

    @Transient
    private int dbIndex = -1;
    @Transient
    private List<RedisServerConfig> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public List<RedisServerConfig> getChildren() {
        return children;
    }

    public void setChildren(List<RedisServerConfig> children) {
        this.children = children;
    }

    @PreUpdate
    public void PreUpdate() {
        setUpdateTime(new Date());
    }

    @PrePersist
    public void PrePersist(){
        setCreateTime(new Date());
    }
}
