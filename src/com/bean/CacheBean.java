package com.bean;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="singleton")
public class CacheBean {
	
	private static ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> map;
	
	public static ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> getMap() {
		if(map==null) {
			return new ConcurrentHashMap<String, ConcurrentLinkedQueue<String>>();
		}
		return map;
	}

	public static void setMap(ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> map) {
		CacheBean.map = map;
	}

	private static ConcurrentLinkedQueue<String> link;

	public static ConcurrentLinkedQueue<String> getLink() {
		if(link == null) {
			link =new ConcurrentLinkedQueue<String>();
		}
		return link;
	}

	public static void setLink(ConcurrentLinkedQueue<String> link) {
		CacheBean.link = link;
	}
	
}
