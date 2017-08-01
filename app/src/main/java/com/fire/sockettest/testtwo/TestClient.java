package com.fire.sockettest.testtwo;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {

	/**
	 * @param args
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		 boolean isConnected = false;
	        String host = "127.0.0.1";
	        int port = 1122;
	        Socket socket = null;
	        try {
//	            socket = SocketFactory.getDefault().createSocket(host, port);
	        	
	        	socket = new Socket(host,port);
	            isConnected = true;
                System.out.println("连接成功！");
	        } catch (ConnectException e) {
	            isConnected = false;
	            e.printStackTrace();
                System.out.println("连接失败！");
	        } catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        if (!isConnected) {
	            return;
	        }

	        Thread.sleep(5000);

	        socket.close();
        System.out.println("断开连接！");
	}

}
