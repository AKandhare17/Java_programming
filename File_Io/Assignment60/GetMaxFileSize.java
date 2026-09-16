import java.io.*;
import java.util.*;
public class GetMaxFileSize
{
    public static void main(String[] args) 
    {
        Scanner Sc=null;
        String Dirname=null;
        Sc = new Scanner(System.in);
        File fobj = null;
        int i=0,Max=0,Fileno=0;
        System.out.println("Enter Name Of Direectory:");
        Dirname=Sc.nextLine();
        fobj = new File(Dirname);
        if(fobj.exists()&&fobj.isDirectory())
        {
        File fArr[]= fobj.listFiles();
        System.out.println("File From "+Dirname+" :-");
        
        Max=(int)fArr[i].length();
        for(i=1;i<fArr.length;i++)
        {
            if(fArr[i].length()>Max)
            {
                Max=(int)fArr[i].length();
                Fileno=i;
            }
        }
           System.out.println("File With Maximum Size:");
            System.out.println(fArr[Fileno].getName()+"\tSize:"+Max);

      

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