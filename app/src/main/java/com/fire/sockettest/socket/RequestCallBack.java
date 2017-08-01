package com.fire.sockettest.socket;

/**
 * Created by Administrator on 2017/8/1.
 */

public interface RequestCallBack {

    void onSuccess(BasicProtocol msg);

    void onFailed(int errorCode, String msg);
}
