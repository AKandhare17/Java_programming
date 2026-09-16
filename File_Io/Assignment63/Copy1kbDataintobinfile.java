import java.io.*;
import java.util.Scanner;
public class Copy1kbDataintobinfile 
{
    public static void main(String[] sargs) 
    {
        Scanner  sc = new Scanner(System.in);
        String fName=null;
        File fobj=null;
        FileInputStream fiobj=null;
        FileOutputStream foobj=null;
        byte b[] = new byte[1024];
        System.out.println("Enter Name Of Destination File:");
        fName=sc.nextLine();
         fobj = new File(fName);
        if(!fobj.exists()|!fobj.isFile())
        {
            System.out.println("File Not Present With Name: "+fName);
            sc.close();
            return;
        }

        try
        {
            fiobj = new FileInputStream("Combined.bin");
            
            foobj = new FileOutputStream(fName);
            int bytesRead = fiobj.read(b);
              foobj.write(b, 0, bytesRead); // write only what was actually read

        

            System.out.println("1Kb Data From Combined.bin Copied into "+fName);

            sc.close();
            fiobj.close();
            foobj.close();

           


        }
        catch(Exception e)
        {
            System.out.println(e);
        }

        
    }
    
}
