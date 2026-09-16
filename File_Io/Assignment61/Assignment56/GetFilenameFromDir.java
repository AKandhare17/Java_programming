import java.io.File;
import java.util.Scanner;

public class GetFilenameFromDir
 {
    public static void main(String[] sargs) 
    {
        Scanner sobj =null;
        String dirName= null;
        int i=0;
        File fobj = null;

          sobj = new Scanner(System.in);
        System.out.println("Enter Directory Name:");
       dirName=sobj.nextLine();
        fobj = new File(dirName);
        if(fobj.isDirectory()&&fobj.exists())
        {
          File fArr[] =  fobj.listFiles();
          
          for(i=0;i<fArr.length;i++)
          {
            System.out.println("Filename:"+fArr[i].getName());
            
          }

          
        }
        else
        {
            System.out.println(dirName+"Not Exist");
        }
        
    }
    
}
