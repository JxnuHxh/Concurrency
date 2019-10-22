package day03;

public class T {
    private static int count = 10;
    public synchronized  static void m(){
        count++;
        System.out.println(Thread.currentThread().getName()+"count="+count);
    }
    public static  void mm(){
        synchronized (T.class){
            count++;
        }
    }
}
