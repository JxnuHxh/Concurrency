package day20;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

//使用ConcurrentQueue 提高并发性
public class TickerSeller4 {
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
