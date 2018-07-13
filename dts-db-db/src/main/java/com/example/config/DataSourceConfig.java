/**
 * Project Name:dts-db-db
 * File Name:DataSourceConfig1.java
 * Package Name:com.example.config
 * Date:2018年7月11日下午4:16:25
 * Copyright (c) 2018, zengpengapple@qq.com All Rights Reserved.
 *
*/

package com.example.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * 
 * @ClassName:  DataSourceConfig   
 * @Description: 配置数据源
 * @author: zengpeng 
 * @date:   2018年7月11日 下午5:13:38
 */
@Configuration
public class DataSourceConfig {
	

    
	
	@Bean
	@Primary
	@ConfigurationProperties(prefix="spring.primary")
	public DataSourceProperties dataSourcePropertiesPrimary() {
		return new DataSourceProperties();
	}
	
	@Primary
	@Bean(name="primaryDs")
	public DataSource datasource1() {
		return dataSourcePropertiesPrimary().initializeDataSourceBuilder().build();
	}
	
	@Primary
	@Bean
	public LocalContainerEntityManagerFactoryBean  primaryEntityManagerFactory() {
		HibernateJpaVendorAdapter  vendorAdapter  = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setDataSource(datasource1());
		factoryBean.setPackagesToScan("com.example.entity1");
		return factoryBean;
	}
	
	

	
	
	@Bean
	@ConfigurationProperties(prefix="spring.secondary")
	public DataSourceProperties dataSourcePropertiesSecondaray() {
		return new DataSourceProperties();
	}

	@Bean(name="secondaryDs")
	public DataSource datasource2() {
		return dataSourcePropertiesSecondaray().initializeDataSourceBuilder().build();
	}
	
	
	@Bean
	public LocalContainerEntityManagerFactoryBean  secondaryEntityManagerFactory() {
		HibernateJpaVendorAdapter  vendorAdapter  = new HibernateJpaVendorAdapter();
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setJpaVendorAdapter(vendorAdapter);
		factoryBean.setDataSource(datasource2());
		factoryBean.setPackagesToScan("com.example.entity2");
		return factoryBean;
	}
	
	
	
	
	
	
	@Bean
	public PlatformTransactionManager  transactionManager() {
		JpaTransactionManager  tx1 = new JpaTransactionManager();
		tx1.setEntityManagerFactory(primaryEntityManagerFactory().getObject());
		JpaTransactionManager  tx2 = new JpaTransactionManager();
		tx2.setEntityManagerFactory(secondaryEntityManagerFactory().getObject());
		ChainedTransactionManager chains = new ChainedTransactionManager(tx1,tx2);
		return chains;
	}
	

}

