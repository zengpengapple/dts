/**
 * Project Name:dts-db-db
 * File Name:UserService.java
 * Package Name:com.example.service
 * Date:2018年7月11日下午5:27:00
 * Copyright (c) 2018, zengpengapple@qq.com All Rights Reserved.
 *
*/

package com.example.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity1.User1;
import com.example.entity2.User2;
import com.example.repository1.PrimaryUserRepository;
import com.example.repository2.SecondaryUserRepository;

@Service
public class UserService {

	
	@Autowired
	private PrimaryUserRepository primaryUserRepository;
	
	
	@Autowired
	private SecondaryUserRepository secondaryUserRepository;
	
	
	public List<User1> getUser1All(){
		List<User1> findAll = primaryUserRepository.findAll();
		return findAll;
	}
	
	
	public List<User2> getUser2All(){
		List<User2> findAll = secondaryUserRepository.findAll();
		return findAll;
	}
	
    @Transactional
	public void save() {
		User1 user1 = new User1(102,"lilei");
		primaryUserRepository.save(user1);
		
		
		
		User2 user2 = new User2(202,"limei");
		secondaryUserRepository.save(user2);
		
		if(1==1) {
			throw new RuntimeException("error");
		}
	
		


	}
}

