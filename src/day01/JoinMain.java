package day01;

public class JoinMain {
    public volatile  static int i=0;
    public static class AddThread extends Thread{
       @Override
        public  void run(){
            for(i=0;i<100000;i++);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        AddThread t1=new AddThread();
        t1.start();
        //t1.join(); 如果没有这个 方法  返回0
        //有Join表示主线程愿意等待t1完成再走
        System.out.println(i);
    }
}
