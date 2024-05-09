package com.mundo.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {

        try {
            Socket socket = new Socket("localhost", 8888);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String result = reader.readLine();
            System.out.println("接收服务端信息: " + result);

            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
