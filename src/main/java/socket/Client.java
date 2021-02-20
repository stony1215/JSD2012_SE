package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * java.net.Socket
 * Socket封装了TCP协议的通讯细节,使用它可以和远端计算建立连接,并通过
 * 它获取一个输入流和一个输出流,使用这两个流的读写数据完成与远端计算机的交互
 * <p>
 * 实例化Socket时需要传入两个参数:
 * 1:服务端的地址信息(IP地址)
 * 用过地址可以找到网络上服务端的计算
 * 2:服务端打开的服务端口
 * 通过这个端口可以找到服务端计算机运行的服务端应用程序
 */
public class Client {
    private Socket socket;

    public Client() {
        try {
            System.out.println("正在连接服务端...");
            socket = new Socket("localhost", 8088);
            System.out.println("与服务端连接成功...");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        //先启动读取服务端发送过来的消息线程
        ServerHandler handler=new ServerHandler();
        Thread t=new Thread(handler);
        t.setDaemon(true);
        t.start();

        try (
                PrintWriter pw = new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream(), "utf-8"
                                )
                        ), true
                );

        ) {//通过输出流给服务端发送一句话
            Scanner scan = new Scanner(System.in);
            System.out.println("请开始输入内容,单独输入exit退出");
            while (true) {
                String line = scan.nextLine();
                if ("exit".equals(line)) {
                    break;
                }
                pw.println(line);


            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        try {
//            OutputStream out=socket.getOutputStream();
//            OutputStreamWriter osw=new OutputStreamWriter(out);
//            BufferedWriter bw=new BufferedWriter(osw);
//            PrintWriter pw=new PrintWriter(bw,true);
//            pw.println("来了老弟");
//
//        } catch (IOException e) {
//            e.printStackTrace();


    }

    public static void main(String[] args) {
        Client client = new Client();
        client.start();
    }
    public class ServerHandler implements Runnable{
        @Override
        public void run() {
            try (
                    BufferedReader br=new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream(),"utf-8"
                            )
                    );
                    ){
                String line;
                while((line=br.readLine())!=null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
//                e.printStackTrace();
            }
        }
    }

}
