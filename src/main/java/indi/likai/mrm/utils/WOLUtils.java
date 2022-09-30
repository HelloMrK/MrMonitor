package indi.likai.mrm.utils;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * WOL工具
 */
public class WOLUtils {
    private static final int PORT = 9;
    private static final String header = "FF:FF:FF:FF:FF:FF";
    private static final String concatStr = ":";


    /**
     *
     * @param macStr 例如"1C:7B:1C:2D:7A:0C"
     * @param ipStr 例如"192.168.1.100"
     */
    public static void wol(String macStr,String ipStr){
        StringBuilder stringBuilder = new StringBuilder(header);
        for (int i = 0; i < 16; i++) {
            stringBuilder.append(concatStr);
            stringBuilder.append(macStr);
        }

        try {
            byte[] bytes = getHexBytes(stringBuilder.toString());
            InetAddress address = InetAddress.getByName(ipStr);
            DatagramPacket packet = new DatagramPacket(bytes, bytes.length, address, PORT);
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);
            socket.close();
            System.out.println("已发送局域网唤醒数据包:"+ipStr);
        } catch (Exception e) {
            System.out.println("无法发送Lan唤醒数据包: " + e);
        }
    }

    private static byte[] getHexBytes(String macStr) throws IllegalArgumentException {
        String[] hex = macStr.split("(\\:|\\-)");
        byte[] bytes = new byte[hex.length];
        try {
            for (int i = 0; i < hex.length; i++) {
                bytes[i] = (byte) Integer.parseInt(hex[i], 16);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("请使用十六进制的字符");
        }
        return bytes;
    }
}