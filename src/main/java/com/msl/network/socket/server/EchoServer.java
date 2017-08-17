package com.msl.network.socket.server;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public final static int DEFAULT_PORT=37;
    public final static String DEFAULT_HOST="localhost";
	
	public static void main(String[] args) {
		ServerSocket server = null;
		Socket connection = null;
		try {
			 server = new ServerSocket(DEFAULT_PORT);
			 System.out.println("1111111111");
			 
			 while (true) {
				connection = server.accept();
				System.out.println("2222222");
				
				BufferedReader clientIn = new BufferedReader(
						new InputStreamReader(connection.getInputStream())
				);
				
				String msg = clientIn.readLine();
				
				System.out.println("msg:"+msg);
				if("exit".equals(msg)) {
					break;
				}
				OutputStream out = connection.getOutputStream();
				out.write(("服务器已经收到你发来的信息["+msg+"]").getBytes("UTF-8"));
				out.flush();
				System.out.println("999999");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (connection!=null) {
					connection.close();
				}
				
				if (server!=null) {
					server.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
