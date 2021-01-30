package socket;

import java.io.IOException;
import java.net.Socket;

/**
 * java.net.Socket
 * Socket封装了TCP协议的通讯细节,使用它可以和远端计算建立连接,并通过
 * 它获取一个输入流和一个输出流,使用这两个流的读写数据完成与远端计算机的交互
 *
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
            socket=new Socket("localhost",8088);
            System.out.println("与服务端连接成功...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void start(){

    }

    public static void main(String[] args) {
        Client client=new Client();
        client.start();
    }
}
