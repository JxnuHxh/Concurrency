package day16;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock5 extends Thread {
    private static ReentrantLock lock=new ReentrantLock(true);
    public void run() {
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "获得锁 ");
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        ReentrantLock5 r1=new ReentrantLock5();
        Thread th1=new Thread(r1);
        Thread th2=new Thread(r1);
        th1.start();
        th2.start();
    }

}
