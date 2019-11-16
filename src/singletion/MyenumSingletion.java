package singletion;

public class MyenumSingletion {
    public enum singletion{
        instance;
    }

}

/*
饿汉式
一开始就创建对象  私有静态对象
*/

/*
懒汉式
public class Singleton {
 2      private static Singleton instance;
 3      private Singleton (){
        4      }
 5      public static Singleton getInstance(){    //对获取实例的方法进行同步
        6        if (instance == null){
            7            synchronized(Singleton.class){
                8                if (instance == null)
                    9                    instance = new Singleton();
                10            }
            11        }
        12        return instance;
        13      }
 }*/
