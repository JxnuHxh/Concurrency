package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Hxh
 * @date: 2019/11/19
 * @description:
 */
public class WorkerTestThread  implements  Runnable{
private Worker worker;
private CountDownLatch cdLatch;

    public WorkerTestThread(Worker worker, CountDownLatch cdLatch) {
        this.worker = worker;
        this.cdLatch = cdLatch;
    }

    @Override
    public void run() {
     worker.doWork();
     cdLatch.countDown();
    }
}
