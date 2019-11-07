package system12306;

import java.util.Vector;

public class System12306 {
    //设计一个单例模式 表明只有一个系统 不让被人用
    private System12306(){ }
    private  static System12306 sys=new System12306();
    public static System12306 getInstance(){
        return sys;
    }
    public Vector<Ticket> tickets=new Vector<>();
    {
        for (int i=10;i<100;i++){
            tickets.add(new Ticket("北京"+i,"深圳"+i,(i%5+5)*25F));
        }
    }
    public Ticket getTicket(){

        try {
            return tickets.remove(0);
        }catch (Exception e){
            return  null;
        }


    }
}
