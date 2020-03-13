package com.chenqi.netty;

public class NettyTest {
    public static void main(String[] args) {
        NettyServer server = new NettyServer();
        server.bind(9999);
    }
}
