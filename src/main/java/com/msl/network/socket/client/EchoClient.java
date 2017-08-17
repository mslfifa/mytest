package com.msl.network.socket.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import com.msl.network.socket.server.EchoServer;

public class EchoClient {

	public static void main(String[] args) {
		PrintWriter out = null;
		BufferedReader networkIn = null;
		try {
			
			Socket theSocket = new Socket(EchoServer.DEFAULT_HOST,EchoServer.DEFAULT_PORT);
			networkIn=new BufferedReader(
					new InputStreamReader(theSocket.getInputStream())
			);
			BufferedReader userIn = new BufferedReader(
					new InputStreamReader(System.in)
			);
			out = new PrintWriter(theSocket.getOutputStream());
			System.out.println("connection to echo server");
			
			while (true) {
				String theLine = userIn.readLine();
				if (".".equals(theLine)) {
					break;
				}
				out.println(theLine);
				out.flush();
				System.out.println(networkIn.readLine());
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (networkIn!=null) {
					networkIn.close();
				}
				if (out!=null) {
					out.close();
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}

}
