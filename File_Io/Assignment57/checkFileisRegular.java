import java.io.*;
import java.util.Scanner;

public class checkFileisRegular
{
    public static void main(String[] sargs)
     {
        File  fobj = null;
        String FileName= null;
        Scanner sobj= null;
        sobj = new Scanner(System.in);
        System.out.println("Enter Name Of file:");
        FileName=sobj.next();
        fobj = new File(FileName);
        if(fobj.isFile())
        {
            System.out.println(FileName+" is Regular File");
          
        }
        else
        {
               System.out.println(FileName+"is Not a Regular File");
        }

    
     sobj.close();
    }
}