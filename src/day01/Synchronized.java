package day01;
/*
synchronized关键字对某个对象加锁
    一个同步方法可以调用另一个同步方法，
   一个线程已经拥有某个对象的锁，再次申请的时候仍然会得到该对象的锁
   也就是说synchronized获得的锁是可重入的
   这里是继承中有可能发生的情形，子类调用父类的同步方法

 */
public class Synchronized {
    private int count = 10;
    private Object object=new  Object();

    public void m1(){
        //修饰代码块，指定加锁对象，对给定对象加锁
        synchronized(object){//任何对象要执行下面的代码，必须要拿到o对象的锁
            count++;
            System.out.println(Thread.currentThread().getName()+"count="+count);
        }
    }
    //修饰实例方法，对当前实例对象this加锁
    public synchronized void m2(){
        System.out.println(Thread.currentThread().getName()+" m2 start");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count++;
        System.out.println(Thread.currentThread().getName()+"count="+count);
        System.out.println(Thread.currentThread().getName()+" m2 end");
    }
    //修饰静态方法，对当前类的Class字节码对象加锁（所有通过该类new出的实例对象都要同步，用的是同一个锁）
    public static synchronized void  m3(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         System.out.println("m3");
    }
    public  void m4(){
        System.out.println(Thread.currentThread().getName()+" m4 start--");
        try{
            Thread.sleep(5000);

        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" --m4 end");
    }

    public static void main(String[] args) {
        Synchronized s=new Synchronized();
        new Thread(()->{
            s.m2();
        }).start();
        new Thread(()->{
            s.m1();
        }).start();

    }
}
