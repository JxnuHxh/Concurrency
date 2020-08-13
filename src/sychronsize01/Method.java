package sychronsize01;

public class Method {
    public  synchronized void m()  {
        System.out.println(1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }
    public  void n()  {

        System.out.println(1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(2);
    }


}
