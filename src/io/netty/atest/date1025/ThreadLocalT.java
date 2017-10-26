package io.netty.atest.date1025;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import io.netty.util.UncheckedBooleanSupplier;

public class ThreadLocalT {
	private static final Map<String, Long> map = new HashMap<String, Long>();
	private static final ThreadLocal<Map<String, Long>> threadMap = new ThreadLocal<>();
	static{
		threadMap.set(map);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		Map<String, Long> map = (Map<String, Long>) threadMap.get();
		begin();
		TimeUnit.SECONDS.sleep(10);
		end();
		System.out.println(map.get("end")-map.get("begin"));
	}
	
	private static void begin(){
		Map<String, Long> map = (Map<String, Long>) threadMap.get();
		map.put("begin", System.currentTimeMillis());
	}
	
	@SuppressWarnings("unchecked")
	private static void end(){
		Map<String, Long> map = (Map<String, Long>) threadMap.get();
		map.put("end", System.currentTimeMillis());
	}
}










