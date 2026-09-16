import java.util.Scanner;
import java.io.*;
import java.nio.file.FileAlreadyExistsException;

public class HandelingFileExceptions
 {
    public static void main(String[] args)
     {
        Scanner sc = new Scanner(System.in);
        String filename=null;
        File fobj=null;
        FileInputStream frobj =null;


       try
       {
        fobj  = new File(filename);
        frobj = new FileInputStream(fobj);
        frobj.available();
        
        frobj.close();
        sc.close();
       }
       catch(FileNotFoundException foe)
       {
       System.out.println("Exception:"+foe);
       }
       catch(IOException ioe)
       {
          System.out.println("Exception:"+ioe);
       }
       catch(SecurityException se)
       {
           System.out.println("Exception:"+se);
       }
       catch(Exception e)
       {
   System.out.println("Exception:"+e);
       }
       

        
    }
    
}
