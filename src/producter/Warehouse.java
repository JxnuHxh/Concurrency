package producter;

import java.util.ArrayList;

public class Warehouse {

    private ArrayList<String> list=new ArrayList<>();
    public synchronized void add()  {
        if(list.size()<20){
        list.add("a");}
        else{
            this.notifyAll();
            try {
                this.wait(); //是访问的对象等待
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public synchronized void get()  {
        if(list.size()>0){
            list.remove(0);
        }else{
            this.notifyAll();
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
