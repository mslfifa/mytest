package com.msl.netty.inaction.chart01;

public class Data {
	private int n,m;

	

	public Data(int n, int m) {
		super();
		this.n = n;
		this.m = m;
	}



	@Override
	public String toString() {
		int r=n/m;
		return n+"/"+m+"="+r;
	}
	
	
}
