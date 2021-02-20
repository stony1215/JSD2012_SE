package thread;

/**
 * sleep 方法要求必须中断异常.(Thread还提供了其他会导致线程阻塞的方法,很多都要求处理
 * 这个异常,情况时一样的)
 * 当一个线程调用sleep方法处于睡眠阻塞的过程中,此时该线程的interrupt方法被调用时,会中断
 * 这个阻塞过程,此时该方法会抛出中断异常
 */
public class SleepDemo2 {
    public static void main(String[] args) {
        Thread lin=new Thread() {
            public void run() {
                System.out.println("林:刚美完容,睡一会吧...");

                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    System.out.println("林:干嘛呢!干嘛呢!都破相了");
                }
                System.out.println("林:醒了!");

            }
        };
        Thread huang=new Thread(){
            public void run(){
                System.out.println("黄:大锤80,小锤40!开始砸墙...");
                try {
                    for(int i=0;i<5;i++) {
                        Thread.sleep(1000);
                        System.out.println("80");

                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("砸完!搞定!");
                lin.interrupt();
            }
        };
        lin.start();
        huang.start();
    }

}
