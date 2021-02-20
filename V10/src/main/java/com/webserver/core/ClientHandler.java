package com.webserver.core;
import com.webserver.http.EmptyRequestException;
import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class ClientHandler implements Runnable{
    private Socket socket;
    public ClientHandler(Socket socket){this.socket=socket;}
    public void run(){
        try {
            HttpRequest request = new HttpRequest(socket);
            HttpResponse response = new HttpResponse(socket);
            String path = request.getUri();
            File file = new File("./webapps/" + path);
            if (file.exists() && file.isFile()) {
                System.out.println("该资源已找到");

                response.putHeader("Content-Type","text/html");
                response.putHeader("Content-Length",file.length()+"");
                response.setEntity(file);

            } else {
                System.out.println("路径不存在!!!!404!!!!!!");
                File notFound = new File("./webapps/root/404.html");
                response.setStatusCode(404);
                response.setStatusReason("NotFound");
                response.putHeader("Content-Type","text/html");
                response.putHeader("Content-Length",notFound.length()+"");
                response.setEntity(notFound);
            }
            response.putHeader("Server","WebServer");
            response.flush();
            System.out.println("响应发送完毕!");
        }catch (EmptyRequestException e){

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
