package testjoin;

public class One extends Thread {
    public void run(){
        System.out.println("Thread one start");
        Two two=new Two();
        two.start();
        try {
            two.join();
            //线程2加入线程1里面 他可以有参数 表示等多少时间就不等了
            //底层源码给调join方法的对象加了锁
            //底层有一个wait方法  所有其他访问的对象都等待
            System.out.println("one 结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
