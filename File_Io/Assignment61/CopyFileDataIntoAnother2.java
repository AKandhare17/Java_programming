import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
public class CopyFileDataIntoAnother2 // reading data byte by byte
{
    public static void main(String[] sargs) throws Exception
    {
        Scanner sc = new Scanner(System.in);
         FileInputStream fiobj = null;
         FileOutputStream foobj = null;
         byte b=0;
        String SrcFile=null,DestFile=null;
        System.out.println("Enter Source File Name:");
        SrcFile=sc.nextLine();
         System.out.println("Enter Destination File Name:");
        DestFile=sc.nextLine();
        
        File fobj = new File(SrcFile);
        if(fobj.exists()==false)
        {
            System.out.println("File Not Exists");
             fobj=null;
             sc.close();
             return;
        }
        File fobj1 =new File(DestFile);
           fiobj = new FileInputStream(fobj);
            foobj = new FileOutputStream(fobj1);
           while (b!=-1)
             {
                b=(byte)fiobj.read();
                foobj.write(b);
            
           }
          
            System.out.println("Data Written from "+SrcFile+" To "+DestFile+" File Sucessfully.");

           fiobj.close();
           foobj.close();
           sc.close();
           fobj=null;
           fiobj=null;
           System.gc();



    }
    
}
