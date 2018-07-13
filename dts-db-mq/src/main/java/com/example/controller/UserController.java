/**
 * Project Name:dts-db-db
 * File Name:UserController.java
 * Package Name:com.example.controller
 * Date:2018年7月11日下午5:28:55
 * Copyright (c) 2018, zengpengapple@qq.com All Rights Reserved.
 *
*/

package com.example.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/save")
	public String save() {
		userService.create();
		return "ok";
	}
}

