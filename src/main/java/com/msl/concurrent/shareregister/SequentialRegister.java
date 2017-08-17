package com.msl.concurrent.shareregister;

public class SequentialRegister<T>  implements Register<T> {
	private T value;
	@Override
	public T read() {
		// TODO Auto-generated method stub
		return value;
	}

	@Override
	public void write(T t) {
		value = t;
		
	}

}
