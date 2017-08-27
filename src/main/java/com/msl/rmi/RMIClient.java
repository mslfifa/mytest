package com.msl.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
	public static void main(String[] args) throws Exception{
		Registry registry=LocateRegistry.getRegistry("127.0.0.1");
		IRemoteHelloWord hello = (IRemoteHelloWord) registry.lookup("helloword");
		String result = hello.sayHello();
		System.out.println("result:"+result);
		
	}
}
