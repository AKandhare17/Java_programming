import java.io.*;
import java.util.*;
public class GetSubDirectoryName
{
    public static void main(String[] args) 
    {
        Scanner Sc=null;
        String Dirname=null;
        Sc = new Scanner(System.in);
        File fobj = null;
        int i=0;
        System.out.println("Enter Name Of Direectory:");
        Dirname=Sc.nextLine();
        fobj = new File(Dirname);
        if(fobj.exists()&&fobj.isDirectory())
        {
        File fArr[]= fobj.listFiles();
        System.out.println("List Of SubDirectories From "+Dirname+":");
        for(i=0;i<fArr.length;i++)
        {
            if(fArr[i].isFile()==false)
            System.out.println(fArr[i].getName());
        }

      

        }
        else
        {
            System.out.println("Directory Not Present");
        }


       fobj=null;
        Sc.close();
        System.gc();
        
    }

}