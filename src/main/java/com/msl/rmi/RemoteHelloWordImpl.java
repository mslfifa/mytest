package com.msl.rmi;

import java.rmi.RemoteException;

public class RemoteHelloWordImpl implements IRemoteHelloWord {

	@Override
	public String sayHello() throws RemoteException {
		
		return "Hello word!";
	}

}
