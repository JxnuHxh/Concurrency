package day04;

public class T implements Runnable {
    private int count = 10;
    public void run(){
        count--;
        System.out.println(Thread.currentThread().getName()+"count="+count);
    }

    public static void main(String[] args) {
        T t=new T();
        for(int i=0;i<5;i++){
            new Thread(t,"THREAD"+i).start();
        }
    }
}
