package day01;

public class Yeild {
    private static boolean ready;
    private static int number;
    private static class ReaderThread extends  Thread{
        public void run(){
            while(ready==false) {
                System.out.println("zhixing1");
                Thread.yield();//暂停当前正在执行的线程对象，并执行其他线程
            }
            System.out.println(number);
        }
    }
    public static void main(String[] args)  {
        new ReaderThread().start();
        number=42;
        ready=true;
    }
}
