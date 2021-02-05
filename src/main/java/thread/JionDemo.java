package thread;

/**
 * 线程提供了一个方法:void jion()
 * 该方法允许一个线程在另一个线程上等待,直到该线程结束后才会结束等待进行自己的操作
 *
 */
public class JionDemo {
    public static boolean isFinish=false;
    public static void main(String[] args) {
        /*
        一个方法的局部内部类中若引用了这个方法的其他局部变量时,这个变量必须被声明
        为final的(JDK8之后,可以不再显示的使用final关键字修饰这个局部变量,
        但是如果被该方法的其他局部变量引用时,它仍然是final的)
         */
        Thread download =new Thread(){
            @Override
            public void run() {
                System.out.println("down:开始下载图片...");
                for(int i=1;i<=100;i++){
                    System.out.println("down:"+i+"%");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                System.out.println("down:图片下载完毕!");
                isFinish=true;
            }
        };
        Thread show=new Thread(){
            @Override
            public void run() {
                /*
                show线程与download线程启动后是并发运行的.
                其中show线程中显示文字的工作是可以和download同时运行
                 */
                System.out.println("show:开始显示文字...");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                System.out.println("show:显示文字完毕!");
                try {
                    System.out.println("show:开始等待download下载图片");
                    download.join();
                    System.out.println("show:等待downl下载完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("show:开始显示图片...");
                if(!isFinish){
                    throw  new RuntimeException("图片加载失败!");
                }
                System.out.println("show:显示图片完毕!");
            }
        };
        download.start();
        show.start();
    }
}
