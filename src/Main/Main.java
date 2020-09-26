package Main;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        while(sc.hasNextLine()){
            String str = sc.nextLine();
            if(str.length()< 8){
                System.out.println("Irregular password");
                continue ;
            }
            int count1 = 0;
            int count2 = 0;
            int count3 = 0;
            int count4 = 0;
            for(int i=0; i<str.length();i++ ){
                if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
                    count1 = 1;
                }else if(str.charAt(i)>='a'&&str.charAt(i)<='z'){
                    count2 = 1;
                }else if(str.charAt(i)>='A'&&str.charAt(i)<='Z'){
                    count3 = 1;
                }else{
                    count4 = 1;
                }
            }
            if((count1+count2+count3+count4)==4){
                System.out.println("OK");
                continue;
            }else{
                System.out.println("Irregular password");
                continue;
            }
        }
    }
}