package thread;
/**
 * 多线程可以让多个代码片段并发执行,造成一种"同时"运行的现象
 *
 * 线程有两种创建方式
 * 方式1:继承Thread并重写run方法
 *
 */
public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread t1=new MyThread1();
        Thread t2=new MyThread2();
        t1.start();
        t2.start();
    }
}
/**
 * 第一种创建线程的方式有点在于结构简单,利于匿名内部类形式创建
 * 缺点有两个:1,由于java是单继承的,这导致如果继承了Thread就无法再继承其他类去复用方法,
 * 实际开发中是非常不方便的
 * 2,定义线程的同时重写了run方法,这导致将任务直接定义在了线程中使得线程与任务存在
 * 必然的耦合关系,不利于线程的重用
 */
class MyThread1 extends Thread{
    public void run(){
        for(int i=0;i<1000;i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("你是谁呀!!!!!!"+i);
        }
    }
} 
class MyThread2 extends Thread{
    public void run(){
        for(int i=0;i<1000;i++){
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("查水表的"+i);
        }
    }
}