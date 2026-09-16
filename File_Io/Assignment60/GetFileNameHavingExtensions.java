import java.io.*;
import java.util.*;
public class GetFileNameHavingExtensions
{
    public static void main(String[] args) 
    {
        Scanner Sc=null;
        boolean bFlag=false;
        String Dirname=null,fExtension=null;
        Sc = new Scanner(System.in);
        File fobj = null;
        int i=0;
        System.out.println("Enter Name Of Directory:");
        Dirname=Sc.nextLine();
        System.out.println("Enter File Extension You Want(followed By .):");
        fExtension=Sc.nextLine();

        fobj = new File(Dirname);
        if(fobj.exists()&&fobj.isDirectory())
        {
        File fArr[]= fobj.listFiles();
        System.out.println("List Of Files From "+Dirname+":");
        System.out.println("File Name With Extension:"+fExtension);
        for(i=0;i<fArr.length;i++)
        {
          if(fArr[i].getName().endsWith(fExtension)==true)
          {
            bFlag=true;
             System.out.println(fArr[i].getName());
          }
        
        
        }

        }
        else
        {
            System.out.println("Directory Not Present");
        }
        
        if(bFlag==false)
        {
            System.out.println("File With "+fExtension+" Not Found.");
        }

       fobj=null;
        Sc.close();
        System.gc();
        
    }

}