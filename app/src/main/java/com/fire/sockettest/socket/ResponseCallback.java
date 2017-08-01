package com.fire.sockettest.socket;

/**
 * Created by Administrator on 2017/8/1.
 */
public interface ResponseCallback {
    void targetIsOffline(DataProtocol reciveMsg);

    void targetIsOnline(String clientIp);
}
