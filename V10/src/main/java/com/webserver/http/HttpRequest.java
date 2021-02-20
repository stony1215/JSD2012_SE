package com.webserver.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private String method;
    private String uri;
    private String protocol;

    private Socket socket;

    Map<String,String> headers=new HashMap<>();
    public HttpRequest (Socket socket)throws EmptyRequestException{
        this.socket=socket;
        parseRequestLine();
        parseHeaders();
        parseContent();
    }
    private void parseRequestLine() throws EmptyRequestException{
        System.out.println("httprequest:开始解析请求行...");
        try {
            String line = readLine();
            if(line.isEmpty()){
                throw new EmptyRequestException("请求不能为空");
            }
            System.out.println("请求行:"+line);
            String[] data=line.split("\\s");
            method=data[0];
            uri=data[1];
            protocol=data[2];
            System.out.println("method:"+method);
            System.out.println("uri:"+uri);
            System.out.println("protocol:"+protocol);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private  void parseHeaders(){
        System.out.println("httprequest:消息头解析完毕");
        try{
            while(true){
            String line=readLine();
            if(line.isEmpty()){
                break;
            }
            System.out.println("消息头:"+line);
            String[] data=line.split(":\\s");
            headers.put(data[0],data[1]);
        }
        System.out.println("headers:"+headers);
    }catch(IOException e){
            e.printStackTrace();
        }
    }
    private  void parseContent(){
        System.out.println("httprequest:正文解析完毕!");
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

    public String getUri() {
        return uri;
    }

    public String getMethod() {
        return method;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getHeader(String name){
        return headers.get(name);
    }
}
