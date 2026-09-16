import java.io.*;
import java.util.*;

public class WriteDataAndNameOFDirectoryFiles
 {
    public static void main(String[] sargs)
     {
        File fobj = null;
        Scanner sobj = null;
        int i=0;
        String DirName = null;
        byte Buffer[] = new byte[10];
        byte NameBuffer[] = new byte[10];
        String Fname= null;
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
                    Fname=fArr[i].getName();
                    NameBuffer=Fname.getBytes();
                   
                     foobj=new FileOutputStream("Marvellous.txt",true);
                     foobj.write(NameBuffer);
                     foobj.write(Buffer);
                      Buffer=null;
                      NameBuffer=null;
                   

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


                    