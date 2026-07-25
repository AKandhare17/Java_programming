import java.util.*;
import java.io.*;
import java.net.*;
public class AdditionClient2
{
    public static void main(String sargs[]) throws Exception
    {
        System.out.println("Client is running....");

    

        Socket sobj = new Socket("localhost",2100);
        System.out.println("Server Sucessfully Connected...");

          DataInputStream diobj = new DataInputStream(sobj.getInputStream());//for input Recieving
          DataOutputStream doobj = new DataOutputStream(sobj.getOutputStream());//for output Sending
    }
    
}
