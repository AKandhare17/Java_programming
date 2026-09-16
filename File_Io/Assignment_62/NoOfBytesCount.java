import java.io.*;
import java.util.Scanner;

public class NoOfBytesCount
{
    public static void main(String[] sargs)
    {
        String fName=null;
        File fobj=null;
        byte buff[]={0};
        int iCount=0;
        FileInputStream frobj = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name Of File:");
        fName=sc.nextLine();

        fobj = new File(fName);
        if(!fobj.exists())
        {
            System.out.println(fName+" Not Exists");
            sc.close();
            return;
        }
        try
        {
        frobj = new FileInputStream(fobj);
        while (frobj.read(buff)!=-1) 
        {
            iCount++;              // ew can also use fobj.length()->returns total no of bytes
           
        }
        System.out.println("No Of Total Bytes: "+(iCount-1));

        frobj.close();
        sc.close();
        fobj=null;

    
    }
    catch(Exception e)
    {
         System.out.println(e);
    }
       


        
    }
    
}
