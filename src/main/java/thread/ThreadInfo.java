package thread;

/**
 * 线程提供了一组获取相关信息的方法
 */
public class ThreadInfo {
    public static void main(String[] args) {
        //获取主线程
        Thread t=Thread.currentThread();
        //获取线程名字
        String name=t.getName();
        System.out.println("name:"+name);

        //获取ID
        long id=t.getId();
        System.out.println("唯一标识:"+id);
        //获取线程的优先级
        int priority=t.getPriority();
        System.out.println("优先级:"+priority);

        //是否活着,线程是否为守护线程,是否被中断
        boolean isAlive=t.isAlive();
        boolean isDaemon=t.isDaemon();
        boolean isInterrupted=t.isInterrupted();
        System.out.println(isAlive+","+isDaemon+","+isInterrupted);
    }
}
