package com.fire.sockettest.testtwo;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TestService {
	
	private int port = 1122;
    private ServerSocket serverSocket;

    public TestService() throws Exception {
        serverSocket = new ServerSocket(port, 3);//显式设置连接请求队列的长度为3
        System.out.println("服务器启动!");
    }

    public void service() {
        while (true) {
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TestService server = new TestService();
        Thread.sleep(3000);
        server.service();
	}

}
