package com.msl.concurrent.shareregister;

public interface Register<T> {
	T read();
	void write(T t);
}
