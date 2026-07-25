import java.util.*;
import java.io.*;
import java.net.*;
public class AdditionClient3
{
    public static void main(String sargs[]) throws Exception
    {
        System.out.println("Client is running....");

    

        Socket sobj = new Socket("localhost",2100);
        System.out.println("Server Sucessfully Connected...");

          DataInputStream diobj = new DataInputStream(sobj.getInputStream());//for input Recieving
          DataOutputStream doobj = new DataOutputStream(sobj.getOutputStream());//for output Sending

          int iNo1=11,iNo2=10;

           doobj.writeInt(iNo1);
          doobj.writeInt(iNo2);



          int iSum =diobj.readInt();
          System.out.println("Addition is:"+iSum);

          sobj.close();

          System.out.println("Client Aplication Terminated...");

    }
    
}
