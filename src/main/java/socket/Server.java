package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class Server {
    /*
    java.net ServerScoket
    ServerScoket是运行在服务端的,它主要有两个作用:
    1:向系统申请并打开服务端口,客户端可以通过这个端口与服务端建立连接
    2:监听服务端口,一旦一个客户端通过该端口与服务端建立连接则会创建一个Socket,
    通过它与客户端进行交互
    如果我们把Socket比喻为电话,那么ServerScoket就相当于总机
     */
    private ServerSocket serverSocket;
    public Server(){

        try {
            System.out.println("正在启动服务端...");
            serverSocket=new ServerSocket(8088);
            System.out.println("服务端已启动...");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void start(){
        try {
            /*
            Socket accept()
            该方法是一个阻塞方法,调用后程序就"卡住"了,此时开始等待客户端的连接,一旦一个客户端建立连接
            此时accept方法会立即返回一个Socket实例,通过这个Socket就可以与连接的客户端进行交互了
             */
            System.out.println("等待客户连接");
           Socket socket=serverSocket.accept();
            System.out.println("一个客户连接了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server=new Server();
        server.start();
    }
}
