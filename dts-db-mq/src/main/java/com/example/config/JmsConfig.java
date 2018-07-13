/**
 * Project Name:dts-db-mq
 * File Name:JmsConfig.java
 * Package Name:com.example.config
 * Date:2018年7月13日下午5:38:29
 * Copyright (c) 2018, zengpengapple@qq.com All Rights Reserved.
 *
*/

package com.example.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.TransactionAwareConnectionFactoryProxy;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

	
	@Bean
	public ConnectionFactory connectionFactory() {
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		TransactionAwareConnectionFactoryProxy proxy =  new TransactionAwareConnectionFactoryProxy();
		proxy.setTargetConnectionFactory(cf);
		proxy.setSynchedLocalTransactionAllowed(true);//允许同步到本地事务
		return proxy;
	}
	
	
	
	@Bean
	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
		JmsTemplate  jmsTemplate  = new JmsTemplate(connectionFactory);
		jmsTemplate.setSessionTransacted(true);
		return  jmsTemplate;
	}
}

