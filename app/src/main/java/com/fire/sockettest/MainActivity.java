package com.fire.sockettest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.fire.sockettest.socket.BasicProtocol;
import com.fire.sockettest.socket.ConnectionClient;
import com.fire.sockettest.socket.DataProtocol;
import com.fire.sockettest.socket.RequestCallBack;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConnectionClient client = new ConnectionClient(new RequestCallBack() {
            @Override
            public void onSuccess(BasicProtocol msg) {
                System.out.println("     msg:"+msg.toString());
            }

            @Override
            public void onFailed(int errorCode, String msg) {
                System.out.println("errorCode:"+errorCode+"     msg:"+msg.toString());
            }
        });

        DataProtocol dataProtocol = new DataProtocol();
        dataProtocol.setDtype(123);
        dataProtocol.setMsgId(456);
        dataProtocol.setPattion(789);


        dataProtocol.setData("zheshisbjwkbcxwjkbckjcnbskncskdncjdjhcjdjjdjdjdjjdjdjdjjdjjd");
        client.addNewRequest(dataProtocol);
    }
}
