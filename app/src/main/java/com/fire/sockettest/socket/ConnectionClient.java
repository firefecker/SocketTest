package com.fire.sockettest.socket;

/**
 * Created by Administrator on 2017/8/1.
 */

public class ConnectionClient {

    private boolean isClosed;

    private ClientRequestTask mClientRequestTask;

    public ConnectionClient(RequestCallBack requestCallBack) {
        mClientRequestTask = new ClientRequestTask(requestCallBack);
        new Thread(mClientRequestTask).start();
    }

    public void addNewRequest(DataProtocol data) {
        if (mClientRequestTask != null && !isClosed)
            mClientRequestTask.addRequest(data);
    }

    public void closeConnect() {
        isClosed = true;
        mClientRequestTask.stop();
    }
}
