package com.chenqi.netty;

public class Client2 {
    public static void main(String[] args) {
        NettyClient client = new NettyClient("127.0.0.1",9999);
        client.start();
    }
}
