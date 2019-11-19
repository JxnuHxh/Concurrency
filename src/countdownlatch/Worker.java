package countdownlatch;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

/**
 * @author: Hxh
 * @date: 2019/11/19
 * @description:
 */
public class Worker {
    private String name;
    private Long workDuration;

    public Worker(String name, Long workDuration) {
        this.name = name;
        this.workDuration = workDuration;
    }
    public void doWork(){
        System.out.println(name+"begins to work...");
        try {
            Thread.sleep(workDuration);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(name+"has finished the job...");
    }
}

