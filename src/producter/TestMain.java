package producter;



public class TestMain {
    public static void main(String[] args) {
        Warehouse house=new Warehouse();//里面有线程不安全
        //两个消费者并发访问只有一个货物时会出现抢夺资源问题
        Producter p=new Producter(house);
        Consumer c1=new Consumer(house);
        Consumer c2=new Consumer(house);
        p.start();
        c1.start();
        c2.start();
    }
}
