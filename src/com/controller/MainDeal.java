package com.controller;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CacheBean;
import com.bean.Data;

@RestController
@RequestMapping(value = "/deal")
@Scope(value="singleton")
public class MainDeal {

	public MainDeal() {
		// TODO Auto-generated constructor stub
		System.out.println("cache 缓存初始化");
	}
	
	@Autowired
	private CacheBean cacheBean;
	
	@GetMapping(value = "/pop")
	public void insert(Data data) {
		String key=data.getKey();
		String dt=data.getData();
//		String tp=cacheBean.getLink().poll();
		ConcurrentLinkedQueue<String> link = cacheBean.getMap().get(key);
		if(link ==  null) {
			System.out.println("null");
		}else {
			System.out.println(link.poll()+"--deal");
		}
	}
}
