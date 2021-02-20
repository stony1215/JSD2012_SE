package com.webserver.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpResponse {
    private int statusCode=200;
    private String statusReason="OK";
    private Map<String,String> headers=new HashMap<>();

    private File entity;
    private Socket socket;
    public HttpResponse(Socket socket){this.socket=socket;}

    public void flush(){
        sendStatusLine();
        sendHeaders();
        sendContent();

    }
    private void sendStatusLine(){
        System.out.println("response开始发送状态行");
        try{
            String line="HTTP/1.1"+" "+statusCode+" "+statusReason;
            println(line);

        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("response状态行发送完毕");
    }


    private void sendHeaders(){
        System.out.println("response开始发送响应头");
        try {
//            Set<Map.Entry<String,String>> set=headers.entrySet();
//            for(Map.Entry<String,String> e :set) {
//                String name = e.getKey();
//                String value=e.getValue();
//                String line=name+":"+value;
//                System.out.println("响应头:"+line);
//                println(line);
//        }
            //JDK8之后Map也支持foreach,使用lamba表达式遍历
            headers.forEach(
                    (k,v)->{
                        try {
                            String line=k+":"+v;
                            System.out.println("响应头:"+line);
                            println(line);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    }
            );

            println("");
        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("response响应头发送完毕");
    }
    private void sendContent(){
        System.out.println("response开始发送响应正文");
        try(
                FileInputStream fis=new FileInputStream(entity);
                ){
            OutputStream out=socket.getOutputStream();
            int len;
            byte[] buf=new byte[1024*10];
            while((len=fis.read(buf))!=-1){
                out.write(buf,0,len);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("response正文响应完毕");
    }
    private  void println(String line) throws IOException {
        OutputStream out=socket.getOutputStream();
        byte[] data=line.getBytes("ISO8859-1");
        out.write(data);
        out.write(13);
        out.write(10);
    }
    public void putHeader(String name,String value){
        headers.put(name,value);
    }

    public File getEntity() {
        return entity;
    }

    public void setEntity(File entity) {
        this.entity = entity;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

}
