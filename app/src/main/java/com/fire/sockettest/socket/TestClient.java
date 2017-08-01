package com.fire.sockettest.socket;


/**
 * Created by Administrator on 2017/8/1.
 */

public class TestClient {

    public static void main(String[] args) {
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
