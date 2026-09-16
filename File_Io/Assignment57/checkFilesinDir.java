import java.io.*;
import java.util.*;

public class checkFilesinDir
 {
    public static void main(String[] sargs)
     {
        File fobj = null;
        Scanner sobj = null;
        int i=0;
        String DirName = null;
        sobj = new Scanner(System.in);
        System.out.println("Enter Directory Name:");
        DirName=sobj.nextLine();
        fobj = new File(DirName);
        if(fobj.exists()&&fobj.isDirectory())
        {
            File fArr[] =fobj.listFiles();
            for(i=0;i<fArr.length;i++)
            {
                System.out.println("Name:"+fArr[i].getName());
                System.out.println("Size:"+fArr[i].length());
            }

        }



        sobj .close();
    }
    
}
