import java.util.Scanner;
import java.io.*;
public class createBackupFile 
{
    public static void main(String[] sargs)
    {
        String fName=null;
        File fobj=null,bfobj=null;
        byte buff[]={' '};
        FileInputStream frobj=null;
        FileOutputStream foobj=null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Your File Name:");
        fName=sc.nextLine();

        fobj = new File(fName);
        if(!fobj.exists())
        {
            System.out.println("File Not Exists");
            sc.close();
            return;

        }

        bfobj = new File("Original_Backup.txt");

        try{

        frobj = new FileInputStream(fobj);
        foobj = new FileOutputStream(bfobj);

        while (frobj.read(buff)!=-1)
        {
            foobj.write(buff);
            
        }

        System.out.println("Backup File Created Original_Backup.txt");
      
         foobj.close();
          frobj.close();
    }
    catch(IOException ioe)
    {
        System.out.println(ioe);

    }
    catch(Exception e)
    {
      
        System.out.println(e);
    }

    finally
    {
    fobj=null;
    bfobj=null;
    sc.close();
    System.gc();
   
    }
        




        
    }
    
}
