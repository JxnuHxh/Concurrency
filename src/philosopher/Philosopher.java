package philosopher;

public class Philosopher extends Thread {
    private String name;
    private Chopstick left;
    private Chopstick right;

    public Philosopher(String name,Chopstick left,Chopstick right){
        this.left=left;
        this.name=name;
        this.right=right;
    }
    public void run(){
        synchronized (left) {
            System.out.println(this.name + "拿起来左手筷子" + this.left.getNum());
            synchronized (right){
                System.out.println(this.name + "拿起来右边筷子" + this.right.getNum());
            System.out.println(this.name+"开始吃饭");
            }
        }
    }

}
