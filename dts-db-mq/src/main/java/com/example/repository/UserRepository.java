/**
 * Project Name:dts-db-mq
 * File Name:UserRepository.java
 * Package Name:com.example.repository
 * Date:2018年7月13日下午5:46:34
 * Copyright (c) 2018, zengpengapple@qq.com All Rights Reserved.
 *
*/

package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>  {

}

