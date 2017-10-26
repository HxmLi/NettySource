package io.netty.atest.date1025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Lock;

import io.netty.channel.ChannelOption;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class Test {
	public static void main(String[] args) {
		
		Class c1 = ArrayList.class;
		Class<?> c2 = new ArrayList<Integer>().getClass();
		Class<?> c3 = new ArrayList<String>().getClass();
		
		ArrayList l1 = new ArrayList<>();
		ArrayList l2 = new ArrayList<String>();
		
		System.out.println(c2 == c3);
		
		System.out.println(l1 == l2);

		l2.add(3);
		l1.add("d");
		
		System.out.println(l1.get(0));
		System.out.println(l2.get(0));
		
		List<String> list = new ArrayList<String>();
		list.add("AAA");
		list.add("BBB");
		list.add("CCC");
		
System.out.println(Arrays.toString(String.class.getTypeParameters()));

System.out.println(NioServerSocketChannel.class.getSimpleName());

System.out.println(ChannelOption.TCP_NODELAY);
	}
}



