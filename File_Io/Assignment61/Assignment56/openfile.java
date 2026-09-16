import java.io.*;
import java.util.*;
public class openfile
{
 public static void main(String sargs[])
 {
    Scanner Sobj =  null;
     File fobj = null;
    String Filename=null;
    Sobj = new Scanner(System.in);

   
    System.out.println("Enter Name Of File:");
    Filename=Sobj.next();
    fobj = new File(Filename);


    Sobj.close();
 }

}