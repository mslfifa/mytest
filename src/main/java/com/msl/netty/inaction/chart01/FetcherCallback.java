package com.msl.netty.inaction.chart01;



public interface FetcherCallback {
	void onData(Data data) throws Exception;
	
	void onError(Throwable cause);
	
}
