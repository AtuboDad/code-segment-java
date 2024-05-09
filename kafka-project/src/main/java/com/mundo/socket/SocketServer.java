package com.mundo.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        OutputStream writer = socket.getOutputStream();

        String msg = "server message";
        writer.write(msg.getBytes());

        writer.close();
        socket.close();
        server.close();

    }
}
