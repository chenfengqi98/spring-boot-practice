package com.chenqi.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.Scanner;

public class NettyClient {
        private String host;
        private int port;

        public NettyClient(String host, int port) {
            this.host = host;
            this.port = port;
        }

        public void start(){
            // 与服务器端类似
            NioEventLoopGroup group = new NioEventLoopGroup();
            try {
                Bootstrap bootstrap = new Bootstrap();
                bootstrap.group(group)
                        .channel(NioSocketChannel.class)
                        .remoteAddress(new InetSocketAddress(host, port))
                        .handler(new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline pipeline = ch.pipeline();
                                pipeline.addLast("handler", new ClientHandler());
                                pipeline.addLast("decoder", new StringDecoder());
                                pipeline.addLast("encoder", new StringEncoder());
                            }
                        });
                Channel channel = bootstrap.connect().sync().channel();
                System.out.println("客户端连接服务器成功");
                Scanner scanner = new Scanner(System.in);
                scanner.useDelimiter("\n");

                while (scanner.hasNext()) {
                    String msg = scanner.nextLine();
                    if ("exit".equals(msg)) {
                        System.out.println("我下线了");
                        channel.close();
                        return;
                    }
                    if (" ".equals(msg)) {
                        continue;
                    }
                    channel.writeAndFlush(msg);
                }
            } catch (Exception e) {
                e.getStackTrace();
            } finally {
                group.shutdownGracefully();
                System.out.println("客户端关闭了");
            }
        }
}