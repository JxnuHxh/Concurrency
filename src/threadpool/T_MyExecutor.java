package threadpool;

import java.util.concurrent.Executor;

public class T_MyExecutor implements Executor {

    public static void main(String[] args) {
        new T_MyExecutor().execute(()->System.out.println("hello executor"));
    }

    @Override
    public void execute(Runnable command) {
        //new Thread(command).run();
        command.run();

    }

}