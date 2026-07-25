import java.io.*;
import java.util.*;
import java.net.*;
public class AdditionServer2
{
    public static void main(String sargs[]) throws Exception
    {
       
        System.out.println("Server is running....");
        ServerSocket ssobj = new ServerSocket(2100);
         System.out.println("Server is Waiting at port no:2100");
         Socket sobj = ssobj.accept();
          System.out.println("Client Request Arrives And Accepted by server.");

          DataInputStream diobj = new DataInputStream(sobj.getInputStream());//for input Recieving
          DataOutputStream doobj = new DataOutputStream(sobj.getOutputStream());//For Output Sending
    }
    
}
