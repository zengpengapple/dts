/**
 * Project Name:dts-db-db
 * File Name:User.java
 * Package Name:com.example.entity1
 * Date:2018年7月11日下午5:23:31
 * Copyright (c) 2018, zengpengapple@qq.com All Rights Reserved.
 *
*/

package com.example.entity2;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User2 {
   
	@Id
    private Integer  id;
	

	private  String  name;
    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User2(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User2() {
		super();
	}
	
	

}

