package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.spec.ECField;
import java.util.*;

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
    //用来保存所有客户端输出流的数组,用于让ClentHandler之间共享输出流广播消息使用
//    private PrintWriter[] all={};
 //   private Collection<PrintWriter> all=new ArrayList<>();
    private List<PrintWriter> all=Collections.synchronizedList(new ArrayList<>());
    public Server(){

        try {
            System.out.println("正在启动服务端...");
            serverSocket=new ServerSocket(8088);
            System.out.println("服务端已启动...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    public void start() {

        try {

            while (true) {
                System.out.println("等待客户端连接...");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端已连接");
                Runnable handler=new ClientHandler(socket);
                Thread t=new Thread(handler);
                t.start();
            /*
            Socket accept()
            该方法是一个阻塞方法,调用后程序就"卡住"了,此时开始等待客户端的连接,一旦一个客户端建立连接
            此时accept方法会立即返回一个Socket实例,通过这个Socket就可以与连接的客户端进行交互了
            System.out.println("等待客户连接");
           Socket socket=serverSocket.accept();
            System.out.println("一个客户连接了");
            Socket提供的方法:
            InputStream getInputStream()
            通过socket获取的输入流可以读取远端计算机发送过来的数据
            InputStream in=socket.getInputStream();
            InputStreamReader isr=new InputStreamReader(in,"utf-8");
            BufferedReader br=new BufferedReader(isr);
             */
            }
        }catch(IOException e){
                e.printStackTrace();
            }
        }

    public static void main(String[] args) {
        Server server=new Server();
        server.start();
    }
    private class ClientHandler implements  Runnable{
        private Socket socket;
        private String host;//当前客户端的IP地址信息


        public ClientHandler(Socket socket) {
            this.socket=socket;
            //通过socket获取远端计算机地址信息
            host=socket.getInetAddress().getHostAddress();
        }

        public void run(){
            PrintWriter pw=null;

            try{
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream(), "utf-8"
                        )
                );

                 pw=new PrintWriter(
                        new BufferedWriter(
                                new OutputStreamWriter(
                                        socket.getOutputStream(),"utf-8"
                                )
                        ),true
                );
                //将当前对应客户端的输出流存入到共享数组allout中.以便广播消息
                //1先对allout数组扩容
//                synchronized (Server.class) {

//                    all = Arrays.copyOf(all, all.length + 1);
//                    //2将当前pw存入数组最后一个位置
//                    all[all.length - 1] = pw;
                    all.add(pw);//如果当前集合时是并发安全的集合,则不需要同步控制了
//                }
                System.out.println(host+"上线了!当前在线人数:"+all.size());

                String line;

                    while ((line = br.readLine()) != null) {
                        String message=line;{
                        System.out.println(host + "说: " + line);
                        //将消息发送给所有客户端
//                        synchronized (Server.class) {
//                        for (int i = 0; i < all.length; i++) {
//                            all[i].println(host + "说:" + line);
//                        }
//                            for(PrintWriter p:all){
//                                p.println(host+"说:"+line);
//                            }//当使用并发安全的集合时,遍历要采取foreach方法
                        all.forEach(p ->p.println(host+"说:"+message));
                    }
                }
            }catch(IOException e){
                e.printStackTrace();
            }finally {
                //处理该客户端断开连接后的操作
                //将对应当前客户端的输出流从共享数组all中删除
//                synchronized (Server.class) {
//                    for (int i = 0; i < all.length; i++) {
//                        if (pw == all[i]) {
//                            all[i] = all[all.length - 1];
//                            all = Arrays.copyOf(all, all.length - 1);
//                            break;
//                        }
//                    }
//                    Iterator<PrintWriter> it=all.iterator();
//                   while(it.hasNext()){
//                       PrintWriter p=it.next();
//                        if(pw==p) {
//                            it.remove();
                all.remove(pw);
                            System.out.println(host+"下线了!当前在线人数:"+all.size());

                        }

                    }

//                }


//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
}
