package com.msl.tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapDemo {
	private static String str = "";
	public static void main(String[] args) {
		List list = new ArrayList();
		list.add(Boolean.TRUE);
		list.add(Double.MAX_VALUE);
		list.add(Float.MAX_VALUE);
		list.add("this is good");
		list.add(new Object());
		
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object obj = (Object) iterator.next();
			System.out.println(obj);
			iterator.remove();
			
		}
		
		
		
		test(1);
		System.out.println(str);
		System.out.println("list size:"+list.size());
		
	}

	
	public static void  test(int i) {
		
		
		try {
			if (i==1) {
				throw new Exception("自定义错误");
			}
			str+="1";
			return;
			
		} catch (Exception e) {
			str+="2";
		}finally {
			str+="3";
		}
	}
}
