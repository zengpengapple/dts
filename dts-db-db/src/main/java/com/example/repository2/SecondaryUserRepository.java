/**
 * Project Name:dts-db-db
 * File Name:PrimaryUserRepository.java
 * Package Name:com.example.repository1
 * Date:2018年7月11日下午5:26:02
 * Copyright (c) 2018, zengpengapple@qq.com All Rights Reserved.
 *
*/

package com.example.repository2;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity2.User2;

public interface SecondaryUserRepository extends JpaRepository<User2, Integer> {

}

