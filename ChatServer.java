import java.io.*;
import java.net.*;
public class ChatServer
 {
    public static void main(String sargs[]) throws Exception
    {
        ServerSocket ssobj =  new ServerSocket(5100);
        System.out.println("Server is waiting at port: 5100 ");


        Socket sobj = ssobj.accept();
         System.out.println("Client Request Accepted Sucessfully....");

        PrintStream pobj = new PrintStream(sobj.getOutputStream());
        BufferedReader bobj1 = new BufferedReader (new InputStreamReader(sobj.getInputStream()));
         BufferedReader bobj2 = new BufferedReader (new InputStreamReader(sobj.getInputStream()));






     String str = bobj1.readLine();
     System.out.println("Client Said:"+str);
     System.out.println("Enter Message for Client:");
     str=bobj2.readLine();
     pobj.println(str);    
     
    }
    
}
