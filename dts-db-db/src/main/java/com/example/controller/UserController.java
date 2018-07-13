/**
 * Project Name:dts-db-db
 * File Name:UserController.java
 * Package Name:com.example.controller
 * Date:2018年7月11日下午5:28:55
 * Copyright (c) 2018, zengpengapple@qq.com All Rights Reserved.
 *
*/

package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity1.User1;
import com.example.entity2.User2;
import com.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUser1All")
	public List<User1> getUser1All() {
		return userService.getUser1All();
	}
	
	@RequestMapping("/getUser2All")
	public List<User2> getUser2All() {
		return userService.getUser2All();
	}
	@RequestMapping("/save")
	public String save() {
		userService.save();
		return "ok";
	}
}

