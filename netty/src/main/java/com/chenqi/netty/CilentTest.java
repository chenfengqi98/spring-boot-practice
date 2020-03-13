package com.chenqi.netty;

import org.junit.Test;

public class CilentTest {
    public static void main(String[] args) {
        NettyClient client = new NettyClient("127.0.0.1",11110);
        client.start();
    }

    @Test
    public void fun() {
        String s = makeCheckSum("414C4D3A4456503A343A30303730264D41433D3030303030303939393939392649443D393939393939265057443D31323334264C414E3D3030264D4F44454C49443D49505F47534D3132265645523D312E30312E30382652544D3D3126616C61726D3D303C39303030303026");
        System.out.println(s);
    }

    private String makeCheckSum(String data) {
        if (data == null) {
            return "";
        }
        int total = 0;
        int num = 0;
        while (num < data.length()) {
            String s = data.substring(num, num + 2);
            total += Integer.parseInt(s, 16);
            num += 2;
        }
        int mod = total % 256;
        String hex = Integer.toHexString(mod);
        if (hex.length() < 2) {
            hex = "0" + hex;
        }
        return hex;
    }

}
