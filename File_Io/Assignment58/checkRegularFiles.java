import java.io.*;
import java.util.*;

public class checkRegularFiles
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
                if(fArr[i].isFile())
                {
                System.out.println("Name:"+fArr[i].getName());
                System.out.println("Regular File");
            }
            else
            {
                 System.out.println("Name:"+fArr[i].getName());
                System.out.println("Not a Regular File");

            }

        }
    }
        else
        {
            System.out.println(DirName+" Not Present");
        }



        sobj .close();
    
    
    }
    
}
