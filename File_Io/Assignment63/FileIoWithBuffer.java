import java.util.Scanner;
import java.io.*;

public class FileIoWithBuffer 
{
    public static void main(String[] sargs) 
    {
        BufferedInputStream biobj=null;
        BufferedOutputStream boobj=null;
        FileInputStream fiobj=null;
        FileOutputStream foobj=null;
        File fobj=null;
        byte buff[]={' '};
        Scanner sc = new Scanner(System.in);
        String Fname=null;

        System.out.println("Enter Name of File");
        Fname=sc.nextLine();

        fobj = new File(Fname);
        
        if(!fobj.exists())
        {
            System.out.println("File Not Exists");
            sc.close();
            return;
        }


        try
        {

        fiobj = new FileInputStream(fobj);
        biobj = new BufferedInputStream(fiobj);
        foobj = new FileOutputStream("Test.txt");
        boobj = new BufferedOutputStream(foobj);
        
       while (biobj.read(buff)!=-1) 
        {
            boobj.write(buff);
        
       } 

       System.out.println("Data From "+Fname+"Written into Test.txt Sucessfully");
        
       boobj.close();
       
       biobj.close();
       
       sc.close();

        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }

    }
    
}
