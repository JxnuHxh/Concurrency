package sychronsize01;

public class TestSynchronized {
    public  void test1() {
        synchronized (this) {

            while (true) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ie) {
                }
            }
        }
    }

    public static   synchronized void test2() {
        while (true) {
            System.out.println(Thread.currentThread().getName()  );
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final TestSynchronized myt2 = new TestSynchronized();
        Thread test1 = new Thread(() ->{
                myt2.test1();
        }, "test1");
        Thread test2 = new Thread(()-> {
                myt2.test2();
        }, "test2");
        test1.start();
        test2.start();
//         TestRunnable tr=new TestRunnable();
//         Thread test3=new Thread(tr);
//         test3.start();
    }
}
