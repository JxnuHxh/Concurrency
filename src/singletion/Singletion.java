package singletion;


import java.util.Arrays;

//多线程实现单例模式
//想更了解参考www.cnblogs.com/xudong-bupt/p/3433643.html
public class Singletion {
    private Singletion(){
        //private修饰的构造函数 保证其他类对象不能直接new出该对象的实例
        System.out.println("single");
    }
    private static class Inner{   //静态内部类
        private static Singletion s=new Singletion();
    }
    public static Singletion getSingle(){
        //该类唯一的public方法
        return Inner.s;
    }

    public static void main(String[] args) {
        Thread[] ths=new Thread[200];
        for(int i=0;i<ths.length;i++){
            ths[i]=new Thread(()->{
                System.out.println(Singletion.getSingle());
            });
        }
        Arrays.asList(ths).forEach(o->o.start());
    }
}
