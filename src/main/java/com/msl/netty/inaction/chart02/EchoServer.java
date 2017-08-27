package com.msl.netty.inaction.chart02;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class EchoServer {
	
	private int port;
	
	public EchoServer(int port) {
		super();
		this.port = port;
	}
	
	public void start() throws Exception {
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(group).channel(NioServerSocketChannel.class).localAddress(port).childHandler(new ChannelInitializer<Channel>() {

				@Override
				protected void initChannel(Channel channel) throws Exception {
					System.out.println("连接... ,client"+channel.remoteAddress());
					channel.pipeline().addLast(new EchoServerHandler());
				}
				
			});
			ChannelFuture f = b.bind().sync();
			System.out.println(EchoServer.class+" started and listen on "+f.channel().localAddress());
			
			f.channel().closeFuture().sync();
		}finally {
			group.shutdownGracefully().sync();
		}
	}
	
	public static void main(String[] args) throws Exception {
		new EchoServer(65535).start();
		
		
	}

}
