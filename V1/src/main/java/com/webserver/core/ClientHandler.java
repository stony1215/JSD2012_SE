package com.webserver.core;



import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ClientHandler implements Runnable{
    private Socket socket;
    public ClientHandler(Socket socket){this.socket=socket;}
    public void run(){
        try {
            String line=readLine();
            System.out.println("请求行:"+line);
            String method;
            String uri;
            String protocol;

            String[] data=line.split("\\s");
            method=data[0];
            uri=data[1];
            protocol=data[2];
            System.out.println("method:"+method);
            System.out.println("uri:"+uri);
            System.out.println("protocol:"+protocol);
            Map<String,String> headers=new HashMap<>();
            while(true){
                line=readLine();
                if(line.isEmpty()){
                    break;
                }
                System.out.println("消息头:"+line);
                data=line.split(":\\s");
                headers.put(data[0],data[1]);
            }
            System.out.println("headers:"+headers);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String readLine() throws IOException {
        InputStream in=socket.getInputStream();
        int d;
        char cur=' ';
        char pre=' ';
        StringBuilder builder=new StringBuilder();
        while((d=in.read())!=-1){
            cur=(char)d;
            if(pre== 13&&cur== 10){
                break;
            }
            builder.append(cur);
            pre=cur;
        }
        return builder.toString().trim();
    }
}
