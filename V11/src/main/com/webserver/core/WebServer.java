package com.webserver.core;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class WebServer {
    private ServerSocket serverSocket;
    public WebServer() {
        System.out.println("正在启动服务端...");
        try {
            serverSocket = new ServerSocket(8088);
            System.out.println("服务器启动成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start() {
        try {
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端已连接...");
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        WebServer webServer=new WebServer();
        webServer.start();
    }

}

