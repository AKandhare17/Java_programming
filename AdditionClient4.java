import java.util.*;
import java.io.*;
import java.net.*;
public class AdditionClient4
{
    public static void main(String sargs[]) 
    {
        System.out.println("Client is running....");
        int iNo1=0,iNo2=0,iSum=0;

    
        Scanner scobj = new Scanner(System.in);
        
        try
        {
        Socket sobj = new Socket("localhost",2100);
        System.out.println("Server Sucessfully Connected...");
        System.out.println("Enter First No:");
        iNo1=scobj.nextInt();
        System.out.println("Enter Second No:");
        iNo2=scobj.nextInt();

          DataInputStream diobj = new DataInputStream(sobj.getInputStream());//for input Recieving
          DataOutputStream doobj = new DataOutputStream(sobj.getOutputStream());//for output Sending

          

           doobj.writeInt(iNo1);
          doobj.writeInt(iNo2);



           iSum =diobj.readInt();
          System.out.println("Addition is:"+iSum);

          sobj.close();
        }
        catch(IOException E)
        {
            System.out.println(E);
        }

          System.out.println("Client Aplication Terminated...");

    }
    
}
