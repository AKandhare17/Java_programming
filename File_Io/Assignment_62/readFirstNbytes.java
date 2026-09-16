import java.io.*;
import java.util.Scanner;

public class readFirstNbytes
{
    public static void main(String[] sargs)
    {
        String fName=null;
        File fobj=null,fobj1=null;
        int N=0;
        FileInputStream frobj = null;
        FileOutputStream foobj=null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Name Of File:");
        fName=sc.nextLine();
        System.out.println("Enter No Of Bytes To read");
        N=sc.nextInt();

        fobj = new File(fName);
        fobj1 = new File("OutputFile.txt");
       

        if(N>fobj.length())
        {
            System.out.println("Invalid No Of Bytes");
            sc.close();
            return;
        }

        if(!fobj.exists())
        {
            System.out.println(fName+" Not Exists");
            sc.close();
            return;
        }
          byte buff[] = new byte[N];
        try
        {
        frobj = new FileInputStream(fobj);
        foobj =new FileOutputStream(fobj1);
          frobj.read(buff,0,N);
          foobj.write(buff, 0, N);

          System.out.println("Data Copied OutputFile.txt Sucessfully");
        

        frobj.close();
        foobj.close();
        sc.close();
        fobj=null;
        fobj1=null;

    
    }
    catch(Exception e)
    {
         System.out.println(e);
    }
       


        
    }
    
}
