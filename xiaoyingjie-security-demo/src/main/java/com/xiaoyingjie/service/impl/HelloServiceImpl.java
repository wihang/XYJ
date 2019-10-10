package com.xiaoyingjie.service.impl;

import org.springframework.stereotype.Service;

import com.xiaoyingjie.service.HelloService;

@Service
public class HelloServiceImpl implements HelloService{
	@Override
	public String greeting(String name) {
		System.out.println("gretting");
		return "hello" + name;
	}
}
