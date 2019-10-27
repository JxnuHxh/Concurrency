package day15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
//给lists添加volatile之后，t2能够接到通知，但是，t2线程的死循环很浪费cpu，如果不用死循环，该怎么做呢？
public class MyContainer2 {
    volatile List lists=new ArrayList();
    public void add(Object o){
        lists.add(o);
    }
    public  int size(){
        return lists.size();
    }

    public static void main(String[] args) {
        MyContainer2 c=new MyContainer2();
        new Thread(()->{
            for (int i=0;i<10;i++){
                c.add(new Object());
                System.out.println("add"+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"t1").start();
        new Thread(()->{
           while(true){
               if(c.size()==5){
                   break;
               }
           }
           System.out.println("t2结束");
        },"t2").start();
    }
}
