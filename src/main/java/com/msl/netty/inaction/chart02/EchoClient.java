package com.msl.netty.inaction.chart02;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class EchoClient {
	private String hostname;
	private int port;

	public EchoClient(String hostname, int port) {
		super();
		this.hostname = hostname;
		this.port = port;
	}

	public void start() throws Exception{
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			Bootstrap b =new Bootstrap();
			
			b.group(group).channel(NioSocketChannel.class)
				.remoteAddress(new InetSocketAddress(hostname, port))
				.handler(new ChannelInitializer<SocketChannel>() {

					@Override
					protected void initChannel(SocketChannel ch) throws Exception {
						ch.pipeline().addLast(new EchoClientHandler());
						
					}
			});
			
			
			ChannelFuture f = b.connect().sync();
			f.channel().closeFuture().sync();
			System.out.println("channel关闭成功....");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println("group数据关闭");
			group.shutdownGracefully().sync();
		}
	}

	public static void main(String[] args)throws Exception {
		new EchoClient("127.0.0.1", 65535).start();;
	}

}
