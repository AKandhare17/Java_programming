import java.io.*;
import java.security.MessageDigest;
import java.util.Scanner;

public class checkSumcalc 
{
    public static void main(String[] sargs)
     {
        File fobj = null;
        Scanner sobj = null;
        MessageDigest mobj = null;
        String str= null;
        sobj =new Scanner(System.in);
        System.out.println("Enter File Name:");
        str=sobj.next();

        fobj = new File(str);
        mobj = new MessageDigest.getValue(fobj);
            
        

        System.out.println("CheckSum Value of File:"fobj.getValue());

        
    }
    
}
