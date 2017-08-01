package com.fire.sockettest.testone;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class TestClient {

	public static void main(String[] args) {
		try {
            Socket client = new Socket("127.0.0.1", 6969);
            OutputStream out = client.getOutputStream();
            DataOutputStream outs = new DataOutputStream(out);
            while (true) {
                Scanner scaner = new Scanner(System.in);
                genProtocol(outs, scaner.next());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	/**
     *  构造协议
     *
     * @param out
     * @param msg
     * @throws IOException
     */
    private static void genProtocol(DataOutputStream out, String msg) throws IOException {
        int type = 1;                          //消息类型
        byte[] bytes = msg.getBytes();         //消息内容
        int totalLen = 1 + 4 + bytes.length;   //消息长度

        out.writeByte(type);                   //写入消息类型
        out.writeInt(totalLen);                //写入消息内容
        out.write(bytes);                      //写入消息长度

        out.flush();
    }
	 
}
