import java.io.*;
import java.util.*;
import java.net.*;
public class AdditionServer1 
{
    public static void main(String sargs[]) throws Exception
    {
       
        System.out.println("Server is running....");
        ServerSocket ssobj = new ServerSocket(2100);
         System.out.println("Server is Waiting at port no:2100");
         Socket sobj = ssobj.accept();
          System.out.println("Client Request Arrives And Accepted by server.");


    }
    
}
