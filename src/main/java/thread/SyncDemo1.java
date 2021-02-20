package thread;

/**
 * 多线程并发的安全问题
 * 当多个线程并发操作统一临界资源时,由于线程切换时机不确定,导致执行操作的顺序混乱,
 * 出现和程序设计执行结果不同的情况,严重时可能导致系统瘫痪.
 * 临界资源:操作过程同时只能被单一线程完整执行的资源.
 */
public class SyncDemo1 {
    public static int bean_t1=0;
    public static int bean_t2=0;
    public static void main(String[] args) {
        Table table=new Table();

        Thread t1=new Thread(){
            @Override
            public void run() {
                while (true){
                    int bean=table.getBean();
                    Thread.yield();
//                    System.out.println(getName()+":::"+bean);
                    bean_t1++;
                }

            }

        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                while (true){
                    int bean=table.getBean();
                    Thread.yield();
//                    System.out.println(getName()+":::"+bean);
                    bean_t2++;
                }
            }
        };
        t1.start();
        t2.start();
    }
}
class Table{
    private int beans=10000;

    public synchronized int getBean(){
        if(beans==0){
            System.out.println("当前豆子数量:"+beans);
            System.out.println("T1的豆子:"+SyncDemo1.bean_t1+"T1的豆子:"+SyncDemo1.bean_t2);
            System.exit(0);
            //throw new RuntimeException("没有豆子了");
        }
        Thread.yield();
        return beans--;
    }
}