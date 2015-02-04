package com.izerui.redis.service;

import com.izerui.redis.entity.ServerConfig;

import java.util.List;

/**
 * Created by serv on 2015/2/3.
 */
public interface RedisExplorerService{
    List<ServerConfig> getServerConfigs();
}
