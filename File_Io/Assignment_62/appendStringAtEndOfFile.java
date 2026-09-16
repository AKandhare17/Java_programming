import java.util.Scanner;
import java.io.*;
public class appendStringAtEndOfFile 
{
    public static void main(String[] sargs) throws Exception
    {
        String info=null,Fname=null;
        File fobj=null;
        FileWriter fwobj=null;
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter Name of File");
        Fname=sobj.nextLine();
        System.out.println("Enter A String You Want To Append:");
        info=sobj.nextLine();

    fobj = new File(Fname);
    fwobj = new FileWriter(fobj,true);
    fwobj.append(" "+info);
   
    System.out.println(info+" Appended into "+Fname+" File Sucessfully");

    fwobj.close();
    fobj=null;
    sobj.close();

    }
    
}
