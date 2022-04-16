package com.greedy.jaegojaego.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.greedy.jaegojaego")
@EnableJpaRepositories(basePackages = "com.greedy.jaegojaego")
public class JpaConfiguration {
}
