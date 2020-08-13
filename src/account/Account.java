package account;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
/*
读写都应该加锁  不然可能会出现脏读  但是会影响性能
 */

public class Account {
    String name;
    double balance;

    public synchronized void set(String name, double balance) {
        this.name = name;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public double getBalance(String name) {
        return this.balance;
    }

    public static void main(String[] args) {
        Account a = new Account();
        new Thread(() -> a.set("zhangsan", 100.0)).start();


        try {
            TimeUnit.SECONDS.sleep(1);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));
        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(a.getBalance("zhangsan"));

    }
}
