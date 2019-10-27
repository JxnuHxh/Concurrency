package day20;

import java.util.Vector;
import java.util.concurrent.TimeUnit;

//分析下面的程序可能会产生哪些问题？
//  使用Vector或者Collections.synchronizedXXX
//  分析一下，这样能解决问题吗？
public class TicketSeller2 {
    static Vector<String> tickets = new Vector<>();


    static {
        for(int i=0; i<1000; i++) tickets.add("票 编号：" + i);
    }

    public static void main(String[] args) {

        for(int i=0; i<10; i++) {
            new Thread(()->{
                while(tickets.size() > 0) {

                    try {
                        TimeUnit.MILLISECONDS.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    System.out.println("销售了--" + tickets.remove(0));
                }
            }).start();
        }
    }
}
