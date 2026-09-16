import java.io.*;
import java.util.Scanner;

public class copyFileintoDirectories
{
    public static void main(String[] args)
    {
        String d1=null,d2=null,Filename=null;
        File fobj=null,fobj2=null,filenameobj=null;
        FileInputStream fiobj = null;
        byte buff[]= new byte[1024];
        FileOutputStream foobj = null;
        int i=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Source Directory Name:");
        d1=sc.nextLine();
         System.out.println("Enter Destination Directory Name:");
        d2=sc.nextLine();
        fobj = new File(d1);
        fobj2 = new File(d2);
        
        if(!fobj.exists()||!fobj2.exists())
        {
            System.out.println("Directory Not Exits");
            sc.close();
            return;
        }

        if(!fobj.isDirectory()||!fobj2.isDirectory())
        {
            System.out.println("It is Not Directory");
            sc.close();
            return;

        }
        try{
           File farr[]= fobj.listFiles();
           for(i=0;i<farr.length;i++)
           {
             Filename=farr[i].getName();
              fiobj = new FileInputStream(farr[i],Filename);
              foobj = new FileOutputStream(fobj2);
               while (fiobj.read(buff)!=0) 
                {
                   foobj.write(buff);
                   buff=null;

               }

           }
            System.out.println("Files from "+d1+"Copied into "+d2);
               fiobj.close();
               foobj.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
           



        
    }
}

/*

task:copy all files from src directory to destination directory
apply logic as per this referance
import java.io.*;

public class CopyFilesFromDirectory {
    public static void main(String[] args) {
        File sourceDir = new File("D:/sourceFolder");
        File destinationDir = new File("D:/destinationFolder");

        // Create destination directory if it doesn't exist
        if (!destinationDir.exists()) {
            destinationDir.mkdirs();
        }

        // Get all files from source directory
        File[] files = sourceDir.listFiles();

        if (files != null) {
            for (File file : files) {

                // Copy only files, not subfolders
                if (file.isFile()) {
                    File destFile = new File(destinationDir, file.getName());

                    try (
                        FileInputStream fis = new FileInputStream(file);
                        FileOutputStream fos = new FileOutputStream(destFile)
                    ) {
                        byte[] buffer = new byte[1024];
                        int bytesRead;

                        while ((bytesRead = fis.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }

                        System.out.println(file.getName() + " copied successfully.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("Source directory not found or empty.");
        }
    }
}


*/