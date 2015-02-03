package com.izerui.redis.configuration;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by serv on 2015/2/3.
 */
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.izerui.*.repository")
@EntityScan(basePackages = "com.izerui.*.entity")
public class JpaConfiguration {
}
