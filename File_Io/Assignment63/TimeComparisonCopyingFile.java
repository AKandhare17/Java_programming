import java.util.Scanner;
import java.io.*;

public class TimeComparisonCopyingFile
 {
    public static void main(String[] sargs)
     {
        String Fname=null;
        Scanner sc = new Scanner(System.in);
        FileInputStream fiobj=null,fiobj2=null;
        File fobj=null;
        byte buff[] = new byte[1];
        Long Start=null,End=null;
        BufferedInputStream bfobj=null;
        
        
        System.out.println("Enter Name Of File:");
        Fname=sc.nextLine();


        fobj = new File(Fname);
        if(!fobj.exists())
        {
            System.out.println("File Not Present");
            sc.close();
            return;
        }

        try{
             sc.close();
            fiobj = new FileInputStream(fobj);
            Start=System.nanoTime();
            while (fiobj.read(buff)!=-1)              //interpretation(slow)
             {}  
          
            End=System.nanoTime();
              fiobj.close();
           
            
      System.out.println("Time Required With Normal Streams:"+(End-Start));

         fiobj2 = new FileInputStream(fobj);
        bfobj = new BufferedInputStream(fiobj2);
        
        Start=System.nanoTime();
        while (bfobj.read(buff)!=-1)  //compilation(fast)
        {}
        End=System.nanoTime();
      
         System.out.println("Time Required With Buffered Streams:"+(End-Start));
         bfobj.close();
          fiobj2.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }



        
    }
    
}
