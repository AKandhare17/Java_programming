import java.io.*;
import  java.util.*;
public class createDir 
{
    public static void main(String[] args) 
    {
        File fobj = null;
        Scanner sobj = null;
        String DirName= null;
        sobj = new Scanner(System.in);
        System.out.println("Enter Directory Name:");
        DirName=sobj.nextLine();
        fobj = new File(DirName);
        fobj.mkdir();
        if(fobj.exists()==false)
        {
            System.out.print(DirName+" is Already present");
        }
        else
        {
             System.out.print(DirName+" created Sucessfully");
        }

     sobj.close();   
    }
    
}
