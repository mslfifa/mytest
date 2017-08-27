package com.msl.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteHelloWord extends Remote {
	String sayHello() throws RemoteException;
}
