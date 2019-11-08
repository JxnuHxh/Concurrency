package testjoin;

public class Two  extends  Thread{
    public void run(){
        System.out.println("thread two start");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("two 结束");

    }
}
