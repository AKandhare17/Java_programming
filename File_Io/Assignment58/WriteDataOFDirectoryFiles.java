import java.io.*;
import java.util.*;

public class WriteDataOFDirectoryFiles
 {
    public static void main(String[] sargs)
     {
        File fobj = null;
        Scanner sobj = null;
        int i=0;
        String DirName = null;
        byte Buffer[] = new byte[10];
        FileInputStream fiobj = null;
        FileOutputStream  foobj = null;
        sobj = new Scanner(System.in);
        System.out.println("Enter Directory Name:");
        DirName=sobj.nextLine();
        fobj = new File(DirName);
        if(fobj.exists()&&fobj.isDirectory())
        {
              File fArr[] =fobj.listFiles();
            try{
              
                  for(i=0;i<fArr.length;i++)
                 {
                    fiobj=new FileInputStream(fArr[i]);
                    Buffer=fiobj.readAllBytes();
                   
                     foobj=new FileOutputStream("Marvellous.txt",true);
                     foobj.write(Buffer);
                      Buffer=null;
                   

                   }
                        
                    System.out.println("Data Written Sucessfully");
               }
               catch(Exception e)
               {
                System.out.println(e);
               }   
             
        }
        else
        {
            System.out.println(DirName+" Not Present");
        }
         
          


   
        sobj .close();
    
    
    }
    
}


                    