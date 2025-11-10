import java.util.*;
public class InputOutput
 {
    public static void main(String sargs[])
    {
        Scanner sobj = new Scanner(System.in);
        int No1=0,No2=0;
        int iAns=0;

        System.out.println("Enter First No:");
        No1=sobj.nextInt();
         System.out.println("Enter Second No:");
        No2=sobj.nextInt();

        iAns=No1+No2;

        System.out.println("Addition is:"+iAns);
        
    }
    
}
