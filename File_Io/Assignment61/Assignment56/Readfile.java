import java.io.*;
import java.util.*;
public class Readfile
{
 public static void main(String sargs[])
 {
    Scanner Sobj =  null;
     File fobj = null;
     String str = null;
     int iRet=0;
     FileInputStream fiobj = null;
     byte Buffer[] = new byte[10];
    String Filename=null;
    Sobj = new Scanner(System.in);
     try{

     
   
    System.out.println("Enter Name Of File:");
    Filename=Sobj.next();
    fobj = new File(Filename);
    if(fobj.exists())
    {
    fiobj = new FileInputStream(fobj);
    iRet=fiobj.read(Buffer,0,Buffer.length);
    str = new String(Buffer);
     System.out.println("Size of File "+iRet+" bytes");
    System.out.println(str);
    
    fiobj.close();
    }
    else
    {
        System.out.println(Filename+" File Not Present");
    }

     }
     catch(Exception e)
     {
        System.out.println("ERROR:"+e);
     }


    Sobj.close();
 }

}
