package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CacheBean;
import com.bean.Data;

@RestController
@RequestMapping(value = "/receive")
@Scope(value="singleton")
public class MainRun {

	public MainRun() {
		// TODO Auto-generated constructor stub
		System.out.println("cache 缓存初始化");
	}
	
	@Autowired
	private CacheBean cacheBean;
	
	@GetMapping(value = "/push")
	public void insert(Data data) {
		String key=data.getKey();
		String dt=data.getData();
		cacheBean.getLink().add(dt);
		
		System.out.println(key+"--"+dt+"--insert");
	}
}
