package concurrentContainer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> strs=new ConcurrentLinkedQueue<>();
        for(int i=0;i<10;i++){
            strs.offer("a"+i);
        }
        System.out.println(strs);
        System.out.println(strs.size());
        System.out.println(strs.poll());//返回值并删除
        System.out.println(strs.size());
        System.out.println(strs.peek());//不删除
        System.out.println(strs.size());
    }
}
