package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列
 * 队列可以保存一组元素,但是存取元素必须遵循先进先出原则
 * java.util.Queue接口,是队列接口
 * Queue继承自Collection,常用实现类:java.util.LinkedList
 */
public class QueueDemo {
    public static void main(String[] args) {
        /*
        由于LinkedList内部是由链表实现的,而链表结构首尾增删元素性能好,因此
        java让LinkedList作为了Queue的实现类使用
         */
        Queue<String> queue=new LinkedList<>();
        queue.offer("one");
        queue.offer("two");
        queue.offer("five");
        queue.offer("three");
        queue.offer("four");
        queue.offer("four");
        queue.offer("four");
        queue.offer("four");
        queue.offer("four");
        System.out.println(queue);
        String str=queue.poll();
        System.out.println(str);
        System.out.println(queue);
        String str1=queue.peek();
        System.out.println(str1);

        while(queue.size()>0){
            System.out.println(queue.poll());
        }
        System.out.println(queue);
    }
}
