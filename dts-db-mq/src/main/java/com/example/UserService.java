/**
 * Project Name:dts-db-mq
 * File Name:UserService.java
 * Package Name:com.example
 * Date:2018年7月13日下午5:48:38
 * Copyright (c) 2018, zengpengapple@qq.com All Rights Reserved.
 *
*/

package com.example;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repository.UserRepository;

@Service
public class UserService {
    
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JmsTemplate jmsTemplate;
	
	
	@Transactional
	public  void create() {
		
		User user  = new User(3, "jack");
		userRepository.save(user);
		
		
		jmsTemplate.convertAndSend("user","{id:1,name:'jack'}");
		//模拟异常,测试回滚
		int i = 1/0;
	}
}

