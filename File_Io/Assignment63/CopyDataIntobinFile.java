import java.io.*;
import java.util.Scanner;

public class CopyDataIntobinFile 
{
    public static void main(String[] sargs)
    {
        File fobj = null;
        FileInputStream fiobj =null;
        String fName=null;
        FileOutputStream foobj=null;
        byte b[]={' '};
        int i=0;
        Scanner sobj = new Scanner(System.in);

        System.out.println("Enter Name Of Directory:");
        fName=sobj.nextLine();


         fobj = new File(fName);
        if(!fobj.exists()||!fobj.isDirectory())
        {
            System.out.println("Diectory Not Present With Name "+fName);
            sobj.close();
            return;
        }
        
        try{
            
        File fArr[]=fobj.listFiles();
        
        
        foobj = new FileOutputStream("Combined.bin",true);
        for(i=0;i<fArr.length;i++) 
        {
            fiobj = new FileInputStream(fArr[i]);
            b=fiobj.readAllBytes();
           foobj.write(b);
            fiobj.close();
           b=null;

        }
        sobj.close();
       
        foobj.close();

         System.out.println("Data From "+fName+" Directory Copied Into Combined.bin");
      
    }catch(Exception e)
    {
        System.out.println(e);
    }
        
    
        
    }
    
}
