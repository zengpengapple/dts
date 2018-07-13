/**
 * Project Name:dts-db-db
 * File Name:JpaPrimaryConfig.java
 * Package Name:com.example.config
 * Date:2018年7月11日下午4:27:19
 * Copyright (c) 2018, zengpengapple@qq.com All Rights Reserved.
 *
*/

package com.example.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(  
	entityManagerFactoryRef="secondaryEntityManagerFactory",
	transactionManagerRef="transactionManager",
	basePackages= { "com.example.repository2" })
public class JpaSecondaryConfig {
	
	
}

