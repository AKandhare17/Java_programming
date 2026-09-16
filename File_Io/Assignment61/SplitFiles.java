import java.io.*;
import java.util.Scanner;
public class SplitFiles
 {
    public static void main(String[] sargs) 
    {
        String Fname=null;
         File fobj =null,fobj1=null,fobj2=null;
         FileReader frobj=null;
         FileWriter fwobj=null;
         
         char Buffer[]={' '};
         int fLen=0,count=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter File Name:");
        Fname=sc.nextLine();

        fobj = new File(Fname);
        if(fobj.exists()==false)
        {
            System.out.println(Fname+" not Exists");
            sc.close();
            return;
        }

        fLen=(int)fobj.length();
    
        fobj1 = new File("FirstHalf.txt");
         fobj2 = new File("SecondHalf.txt");

         try{

         frobj = new FileReader(fobj);
         fwobj = new FileWriter(fobj1);
        while ((count<fLen/2)&&(frobj.read(Buffer)!=-1))
         {
            
            fwobj.write(Buffer);
            count++;
        } 
        
        frobj.close();
        fwobj.close();


        frobj = new FileReader(fobj);
        fwobj = new FileWriter(fobj2);


         frobj.skip(fLen/2);
        while (frobj.read(Buffer)!=-1)
         {
            fwobj.write(Buffer);
         }

         frobj.close();
         fwobj.close();
         sc.close();
         fobj=null;
         fobj1=null;
         fobj2=null;
         System.gc();

         System.out.println(Fname+" Splited Sucessfully in FirstHalf.txt and SecondHalf.txt");
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
        
    }
    
}
