package com.msl.netty.inaction.chart04;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.oio.OioServerSocketChannel;
import io.netty.util.CharsetUtil;

public class NettyOioServer {
	public void server(int port) throws Exception{
		final ByteBuf  buf =Unpooled.unreleasableBuffer(Unpooled.copiedBuffer("Hi!\r\n",CharsetUtil.UTF_8));
		
		NioEventLoopGroup group = new NioEventLoopGroup();
		
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(group).channel(OioServerSocketChannel.class).localAddress(new InetSocketAddress(port))
			.childHandler(new ChannelInitializer<Channel>() {

				@Override
				protected void initChannel(Channel ch) throws Exception {
					ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {

						@Override
						public void channelActive(ChannelHandlerContext ctx) throws Exception {
							ctx.writeAndFlush(buf.duplicate()).addListener(ChannelFutureListener.CLOSE);
						}
						
					});
				}
			});
			
			
			ChannelFuture f = b.bind().sync();
			f.channel().closeFuture().sync();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			group.shutdownGracefully();
		}
		
	}
}
