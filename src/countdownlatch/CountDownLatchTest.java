package countdownlatch;

import java.util.concurrent.CountDownLatch;

/**
 * @author: Hxh
 * @date: 2019/11/19
 * @description:
 */
public class CountDownLatchTest {
    private static final int MAX_WORK_DURATION=5000;//最大工作时间
    private static final int MIN_WORK_DURATION=1000;//最小工作时间

    private static  Long getRandomWorkDuration(long min,long max){
        return (long)(Math.random()*(max-min)+min);
    }

    public static void main(String[] args) {
        CountDownLatch latch =new CountDownLatch(2);  //创建倒计时门闩 并指定倒计时次数为2
        Worker w1=new Worker("黄小华",getRandomWorkDuration(MIN_WORK_DURATION,MAX_WORK_DURATION));
        Worker w2=new Worker("大华",getRandomWorkDuration(MIN_WORK_DURATION,MAX_WORK_DURATION));
        new Thread(new WorkerTestThread(w1,latch)).start();
        new Thread(new WorkerTestThread(w2,latch)).start();
       try {
           latch.await(); //等待倒计时门闩减到0
           System.out.println("All jobs has finished");
       }catch (InterruptedException e){
           e.printStackTrace();
       }
    }
}
