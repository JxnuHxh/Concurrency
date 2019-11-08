package philosopher;

public class TestMain {
    public static void main(String[] args) {
        Chopstick c1=new Chopstick(1);
        Chopstick c2=new Chopstick(2);
        Chopstick c3=new Chopstick(3);
        Chopstick c4=new Chopstick(4);

        Philosopher p1=new Philosopher("哲学家a",c1,c2);
        Philosopher p2=new Philosopher("哲学家b",c3,c2);
        Philosopher p3=new Philosopher("哲学家c",c4,c3);
        Philosopher p4=new Philosopher("哲学家d",c1,c4);
        p1.start();
        p2.start();
        p3.start();
        p4.start();


    }
}
