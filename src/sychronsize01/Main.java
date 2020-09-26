package sychronsize01;

public class Main {
    public static void main(String[] args) {
        Method demo = new Method();
        new Thread(() -> {
            demo.m();
        }).start();
        Method demo2 = new Method();
        new Thread(() -> {
            demo.n();
        }).start();
    }
}
