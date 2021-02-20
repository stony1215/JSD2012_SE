package com.webserver.core;



import com.webserver.http.HttpRequest;

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
            HttpRequest request=new HttpRequest(socket);
            String path=request.getUri();
            File file=new File("./webapps/"+path);
            if(file.exists()&&file.isFile()){
                OutputStream out=socket.getOutputStream();
                String line="HTTP/1.1 200 OK";
                byte[] data=line.getBytes("ISO8859-1");
                out.write(data);
                out.write(13);
                out.write(10);

                line="Content-Type: text/html";
                data=line.getBytes("ISO8859-1");
                out.write(data);
                out.write(13);
                out.write(10);

                line="Content-Length: "+file.length();
                data=line.getBytes("ISO8859-1");
                out.write(data);
                out.write(13);
                out.write(10);

                out.write(13);
                out.write(10);

                FileInputStream fis=new FileInputStream(file);
                int len;
                byte[] buf=new byte[1024*10];
                while((len=fis.read(buf))!=-1){
                    out.write(buf,0,len);
                }
                System.out.println("响应发送完毕!");
            }else {
                System.out.println("路径不存在!!!!404!!!!!!");
                File notfound = new File("./webapps/root/404.html");

                OutputStream out = socket.getOutputStream();
                String line = "HTTP/1.1 404 Not Found";
                byte[] data = line.getBytes("ISO8859-1");
                out.write(data);
                out.write(13);
                out.write(10);

                line = "Content-Type: text/html";
                data = line.getBytes("ISO8859-1");
                out.write(data);
                out.write(13);
                out.write(10);

                line = "Content-Length: " + notfound.length();
                data = line.getBytes("ISO8859-1");
                out.write(data);
                out.write(13);
                out.write(10);

                out.write(13);
                out.write(10);

                FileInputStream fis = new FileInputStream(notfound);
                int len;
                byte[] buf = new byte[1024 * 10];
                while ((len = fis.read(buf)) != -1) {
                    out.write(buf, 0, len);
                }
                System.out.println("响应发送完毕!");
            }


        } catch (Exception e) {

        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
