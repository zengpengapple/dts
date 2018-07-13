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
	entityManagerFactoryRef="primaryEntityManagerFactory",
	transactionManagerRef="transactionManager",
	basePackages= { "com.example.repository1" })//设置repository使用的数据源
public class JpaPrimaryConfig {
	
	
}

