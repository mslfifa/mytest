package com.msl.netty.inaction.chart04;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;



public class PlainNioServer {

	public void server(int port)  throws Exception{
		System.out.println("listening for connection on port:"+port);
		Selector selector = Selector.open();
		ServerSocketChannel serverChannel = ServerSocketChannel.open();
		ServerSocket serverSocket = serverChannel.socket();
		
		serverSocket.bind(new InetSocketAddress( port));
		
		serverChannel.configureBlocking(false);
		
		serverChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		final ByteBuffer msg = ByteBuffer.wrap("Hi!\r\n".getBytes());
		
		while (true) {
			int n=selector.select();
			if (n>0) {
				Iterator<SelectionKey> ir = selector.selectedKeys().iterator();
				
				while (ir.hasNext()) {
					SelectionKey key = ir.next();
					ir.remove();
					try {
						if (key.isAcceptable()) {
							ServerSocketChannel server = (ServerSocketChannel) key.channel();
							SocketChannel client = server.accept();
							System.out.println("accepted connection from "+client);
							client.configureBlocking(false);
							client.register(selector, SelectionKey.OP_WRITE,msg.duplicate());
						} else if(key.isWritable()){
							SocketChannel client=(SocketChannel) key.channel();
							ByteBuffer buf = (ByteBuffer) key.attachment();
							while (buf.hasRemaining()) {
								if (client.write(buf)==0) {
									break;
								}
							}
							
							client.close();
						}
					} catch (Exception e) {
						
					}finally {
						key.cancel();
						key.channel().close();
					}
				}
			}
		}
	}
	
}
