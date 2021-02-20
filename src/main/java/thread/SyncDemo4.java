package thread;

public class SyncDemo4 {
    public static void main(String[] args) {
        Foo f=new Foo();
        Thread t1=new Thread(){
            @Override
            public void run() {
                f.methodA();
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                f.methodB();
            }
        };
        t1.start();
        t2.start();
    }
}
class Foo{
    public synchronized void methodA(){
        Thread t=Thread.currentThread();
        System.out.println(t.getName()+":正在执行A方法...");
        try {
            Thread.sleep(5000);
            System.out.println(t.getName()+":执行A完毕!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    public synchronized void methodB(){
    public void methodB(){
        synchronized (this) {
            Thread t = Thread.currentThread();
            System.out.println(t.getName() + ":正在执行B方法...");
            try {
                Thread.sleep(5000);
                System.out.println(t.getName() + ":执行B完毕!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}