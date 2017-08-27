package com.msl.netty.inaction.chart01;

public class Worker {
	public void dowork() {
		Fetcher fetcher = new MyFetcher(new Data(1,0));
		
		fetcher.fetchData(new FetcherCallback() {
			
			@Override
			public void onError(Throwable cause) {
				System.out.println("a error accout:"+cause.getMessage());
			}
			
			@Override
			public void onData(Data data) throws Exception {
				System.out.println("data receive:"+data);
			}
		});
		
	}
	
	public static void main(String[] args) {
		Worker w = new Worker();
		w.dowork();
	}
	
}
