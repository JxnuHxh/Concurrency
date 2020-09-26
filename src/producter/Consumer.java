package producter;

public class Consumer extends Thread {
    private Warehouse house;
    public Consumer(Warehouse house){
        this.house=house;
    }
    public void run(){
        while(true){
            house.get();
            System.out.println("消费者拿走了一件货物");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
