package com.izerui.redis.repository;

import com.izerui.redis.entity.ServerConfig;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by serv on 2015/2/3.
 */
public interface ServerConfigRepository extends JpaRepository<ServerConfig,String> {
}
