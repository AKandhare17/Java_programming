import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class copyingfile
{
public static void main(String[] args)
{
    File fobj = null;
     File fobj2 = null;
    String SourceFile = null;
    FileInputStream fiobj=null;
    int iRet=0;
    FileOutputStream foobj = null;
    String DestFile = null;
    Scanner sobj = null;
    byte Buffer[]= new byte[100];
    
    


    sobj = new Scanner(System.in);
    System.out.println("Enter Source file name:");
    SourceFile=sobj.nextLine();

   System.out.println("Enter Destination file name:");
    DestFile=sobj.nextLine();
    
    fobj = new File(SourceFile);
    fobj2 = new File(DestFile); 
    
      
    if(fobj.exists()==false)
    {
        System.out.println("ERROR:File Already Present");
    }
     else
     {
        
        
        try{
           fobj2.createNewFile();
        fiobj = new FileInputStream(fobj);
        foobj = new FileOutputStream(fobj2);

        iRet=fiobj.read(Buffer,0,10);
        System.out.println(iRet);

          System.out.println(new String(Buffer));
           fiobj.close();
    
        foobj.write(Buffer, 0, iRet);
        System.out.println(iRet);
        System.out.println("Data Written Sucessfully");
        
    
       
        foobj.close();
      }
      catch(Exception e)
      {
        System.out.println("ERROR:"+e);
      }
     }



   sobj.close(); 
}

}