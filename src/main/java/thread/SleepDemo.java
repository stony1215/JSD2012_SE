package thread;

/**
 * 线程提供的方法
 * static void sleep(long ms)
 * 该方法可以让运行这个方法的线程处于阻塞状态指定毫秒.超时后线程会自动回到Runnable状态
 * 再次获取时间片并发运行
 */
public class SleepDemo {
    public static void main(String[] args) {
        System.out.println("程序开始了...");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("程序结束了!");
    }
}
