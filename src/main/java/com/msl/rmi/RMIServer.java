package com.msl.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {

	public static void main(String[] args) {
		try {
			IRemoteHelloWord helloWord = new RemoteHelloWordImpl();
			IRemoteHelloWord stub = (IRemoteHelloWord) UnicastRemoteObject.exportObject(helloWord, 9999);
			LocateRegistry.createRegistry(1099);
			Registry registry=LocateRegistry.getRegistry();
			registry.bind("helloword", stub);
			System.out.println("绑定成功");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
