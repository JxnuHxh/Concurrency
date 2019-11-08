package producter;

import java.io.PipedOutputStream;

public class Producter extends  Thread{
    ///为了保证消费者生产者用同一个仓库对象
    private  Warehouse house;
    public Producter(Warehouse house){
        this.house=house;
    }
    //一直向仓库放元素
    public void run(){
        while (true){

                house.add();

            System.out.println("生产了一件货物");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
