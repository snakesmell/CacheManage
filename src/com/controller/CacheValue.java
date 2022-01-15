package com.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.CacheBean;
import com.bean.Data;

@RestController
@RequestMapping(value = "/show")
@Scope(value="singleton")
public class CacheValue {

	@Autowired
	private CacheBean cacheBean;
	
	@GetMapping(value = "/query")
	public String getAll(Data data) {
		
		ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> map = cacheBean.getMap();
		if(data!=null & data.getKey()!=null) {
			ConcurrentLinkedQueue<String> link = map.get(data.getKey());
			HashMap hm = new HashMap();
			hm.put("value", link);
			String json=JSONObject.toJSONString(hm);
			return json;
		}else {
			String json=JSONObject.toJSONString(map);
			return json;
		}
	}
	
	@GetMapping(value = "/queryName")
	public String getAllName() {
		
		ConcurrentHashMap<String, ConcurrentLinkedQueue<String>> map = cacheBean.getMap();
		KeySetView<String, ConcurrentLinkedQueue<String>> set = map.keySet();
		Iterator<String> iter = set.iterator();
		JSONArray arry = new JSONArray();
		JSONArray arryValue = new JSONArray();
		while(iter.hasNext()) {
			String key = iter.next();
			int value = map.get(key).size();
//			JSONObject obj = new JSONObject();
//			obj.put(key, value);
			arry.add(key);
			arryValue.add(value);
		}
		JSONObject obj = new JSONObject();
		obj.put("key", arry);
		obj.put("value", arryValue);
		return obj.toJSONString();
	}
}
