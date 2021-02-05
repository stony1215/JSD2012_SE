package thread;

public class CurrentThreadDemo {
    public static void main(String[] args) {
        Thread main=Thread.currentThread();
        System.out.println("运行main方法的线程是:"+main);
        dosome();
        Thread t=new Thread(){
            public void run(){
                for(int i=0;i<1000;i++) {
                    System.out.println("你好自定义很长很长很长很长"+i);
                }
            }
        };

        t.start();
        for(int i=0;i<1000;i++) {
            System.out.println("你好主函数"+i);
        }
    }
    public static void dosome(){
        Thread t=Thread.currentThread();
        for(int i=0;i<1000;i++) {
            System.out.println("hellodosome:"+i);
        }
    }
}
