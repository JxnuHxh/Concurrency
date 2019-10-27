package day20;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

//使用ConcurrentQueue 提高并发性
//使用早期的同步容器以及Collections.synchronized***方法的不足之处，请阅读：
//http://blog.csdn.net/itm_hadf/article/details/7506529
//
//使用新的并发容器
//http://xuganggogo.iteye.com/blog/321630
public class TicketSeller4 {
   static Queue<String> tickets=new ConcurrentLinkedQueue<>();
   static {
       for (int i=0;i<1000;i++)
           tickets.add("票号 "+i);
   }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            new Thread(()->{
                while(true){
                    String s=tickets.poll();
                    if(s==null)break;
                    else System.out.println("销售了--"+s);
                }
            }).start();
        }
    }
}
