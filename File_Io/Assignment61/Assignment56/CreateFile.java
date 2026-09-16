import java.io.File;
import java.util.Scanner;

public class CreateFile 
{
    public static void main(String[] sargs) 
    {
        Scanner sobj=null;
        String Filename= null;
        File fobj =null;
        sobj = new Scanner(System.in);
        try{
            System.out.println("Enter Name Of File:");
            Filename=sobj.nextLine();
            fobj =  new File(Filename);
            if(fobj.exists())
            {
                System.out.println("File Already Present");
            }
            else
            {
                fobj.createNewFile();
                 System.out.println("File created Sucessfully");

            }

      
        sobj.close();
       }
       catch(Exception e)
       {
        System.out.println("ERROR:"+e);
       }
    }

    
}
