import java.io.*;
import java.util.*;
public class WriteAtEndOfFile
{
 public static void main(String sargs[])
 {
    Scanner Sobj =  null;
     File fobj = null;
     FileWriter fwobj=null;
      String data = null;
   String Filename=null;
    Sobj = new Scanner(System.in);
     try{

     
   
    System.out.println("Enter Name Of File:");
    Filename=Sobj.next();
    fobj = new File(Filename);
    if(fobj.exists())
    {
     data = "Jay Ganesh";
    fwobj = new FileWriter(Filename,true);
   fwobj.write(data);
    
    
   
    
    fwobj.close();
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
