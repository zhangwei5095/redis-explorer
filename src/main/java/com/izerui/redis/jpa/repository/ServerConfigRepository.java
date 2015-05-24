package com.izerui.redis.jpa.repository;

import com.izerui.redis.jpa.entity.RedisServerConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by serv on 2015/2/3.
 */
public interface ServerConfigRepository extends JpaRepository<RedisServerConfig,String> {
}
