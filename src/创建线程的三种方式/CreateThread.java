package 创建线程的三种方式;

public class CreateThread {
    static class MyThread1 extends Thread{
        @Override
        public void run(){
            System.out.println("hxh");
        }
    }
    static class MyThread2 implements Runnable{

        @Override
        public void run() {
            System.out.println("hxh");
        }
    }

    public static void main(String[] args) {
        new MyThread1().start();
        new Thread( new MyThread2()).start();
        new Thread(()->{
            System.out.println("hxh");
        },"线程名，该方式是方法2的一种lamda表达式").start();
    }
}
