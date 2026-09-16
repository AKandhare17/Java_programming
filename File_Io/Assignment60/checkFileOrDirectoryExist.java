import java.io.*;
import java.util.*;
public class checkFileOrDirectoryExist
{
    public static void main(String[] args) 
    {
        Scanner Sc=null;
        String fPath=null;
        Sc = new Scanner(System.in);
        File fobj = null;
        System.out.println("Enter Path Of File/Directory:");
        fPath=Sc.nextLine();
        fobj = new File(fPath);
         if(fobj.exists()==true)
         {
            if(fobj.isDirectory())
            {
                System.out.println("It is Directory:"+fobj.getName());
            }
            if(fobj.isFile())
            {
                System.out.println("It is File:"+fobj.getName());
            }
         }
         else
         {
            System.out.println("Invalid Path");
         }
    
       
       
        

       fobj=null;
        Sc.close();
        System.gc();
        
    }

}