package com.webserver.core;
import com.webserver.http.EmptyRequestException;
import com.webserver.http.HttpRequest;
import com.webserver.http.HttpResponse;

import javax.xml.ws.http.HTTPBinding;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

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
                response.setEntity(file);

            } else {
                System.out.println("路径不存在!!!!404!!!!!!");
                File notfound = new File("./webapps/root/404.html");
                response.setStatusCode(404);
                response.setStatusReason("NotFound");
                response.setEntity(notfound);
            }
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
