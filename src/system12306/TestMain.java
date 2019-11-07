package system12306;

public class TestMain {
    public static void main(String[] args) {
        Window w1=new Window("南昌西");
        Window w2=new Window("北京西");
        Window w3=new Window("深圳北");
        w1.start();
        w2.start();
        w3.start();
    }
}
