import java.io.*;
import java.util.*;

//File PAcking Class
class FilePackerUnpacker
{
    private final byte Key;
    private static final byte[] MAGIC = {0x50, 0x4B, 0x55, 0x56}; // for Magic Number
    
    {
      this.Key=0x11;
    }

    public boolean filePacker(String DirName,String FileName) 
    {
      
     boolean bRet=false;
     String header=null;
     int i=0,iRet=0,j=0;
    byte Buffer[] = new byte[1024];
    byte bheader[] = new byte[100];
    File PackObj =null;
     FileOutputStream foobj =null;
    FileInputStream fiobj = null;
    File fobj=null;
try{
      
    PackObj= new File(FileName);
     PackObj.createNewFile();
     
     foobj  = new FileOutputStream(PackObj);

       foobj.write(MAGIC, 0, MAGIC.length);
     
     fobj = new File(DirName);
     
     if((fobj.exists())&& (fobj.isDirectory()))
        {
          bRet=true;
            System.out.println("Folder is Present");
            
            File fArr [] = fobj.listFiles();
            
            System.out.println("No of Files:"+fArr.length);

             for(i=0;i<fArr.length;i++)
             {
                fiobj = new FileInputStream(fArr[i]);
                
                if(fArr[i].getName().endsWith(".txt"))
                 {
                    //Header Formation
                    header=fArr[i].getName() + " " + fArr[i].length();

                        for(j=header.length();j<100;j++)
                        {
                            header=header+" ";
                        }
                         bheader=header.getBytes();

                         //Write Header into Packed File
                         foobj.write(bheader,0,100);

                   //read data from input files from MyFiles folder      
                   while ((iRet=fiobj.read(Buffer))!=-1)
                   {
                     //Encryption Logic
                     for(j=0;j<iRet;j++)
                     {
                        Buffer[j]=(byte)(Buffer[j]^this.Key);
                     }

                     //write files data into Packed file
                      foobj.write(Buffer,0,iRet);
                   }
                 
                 }
                fiobj.close();
             }
             PackObj.setReadOnly();//make file readonly so misaken edits not happen

             System.out.println("Files From "+DirName+" Directory Packed into "+FileName+" Sucessfully.");
             
             foobj.close();
             
            }  
        else
        {
           foobj.close();
           return bRet;
        }       
        }
        catch(Exception E)
        {
          System.out.println("Error Occured:"+E);
        }
        return bRet;
        
    }

    //magic no validation logic
      public boolean isValidPackedFile(String FileName)
    {
        try
        {
            FileInputStream fiobj = new FileInputStream(new File(FileName));
            byte readMagic[] = new byte[4];
            fiobj.read(readMagic, 0, 4);//reading magic no first
            fiobj.close();
 
            if(readMagic[0] == MAGIC[0] && readMagic[1] == MAGIC[1] && readMagic[2] == MAGIC[2] && readMagic[3] == MAGIC[3]==true)
            {
              return true;// if valid magic no return true
            }
            else
            {
              return false; // otherwise false
            }
        }
        catch(Exception E)
        {
            System.out.println(E);
            return false;// exeption occur return false
        }
    }


  public boolean fileUnpacker(String PackFile)
  {
     //variable creation
      int FileSize=0;
    int i=0,iRet=0;
     boolean bRet=false;
      String tokens[]=null;
      String Header=null;
      File fpackobj = null;
      File fobj = null;
      FileInputStream fiobj =null;
      FileOutputStream foobj = null;
      byte Bheader[] = new byte[100];
      byte Buffer[]  = null;
       

     
try{
       fpackobj = new File(PackFile);
        if(fpackobj.exists()==false)
       {
        return bRet;
      }
             bRet =true;
            fiobj = new FileInputStream(fpackobj);

               fiobj.skip(MAGIC.length);// skip magic no in packed file before reading

         //Reading header
        while((iRet = fiobj.read(Bheader,0,100)) !=-1)
        {
               Header = new String(Bheader);//Byte to String Conversion(explicit)

               Header = Header.trim();

               tokens = Header.split(" ");

              System.out.println("File Name:"+tokens[0]);
               System.out.println("File Size:"+tokens[1]);

                fobj = new File(tokens[0]);
                fobj.createNewFile();
                foobj = new FileOutputStream(fobj);

              FileSize = Integer.parseInt(tokens[1]);

               //buffer for reading filesize
            Buffer = new byte[FileSize];
    
              //read from packed file
               fiobj.read(Buffer,0,FileSize);

              //Decrypting data
               for(i=0;i<FileSize;i++)
               {
                   Buffer[i]=(byte)(Buffer[i]^this.Key);
               }

               //write into extracted file
                foobj.write(Buffer,0,FileSize);
   
        }
  
               System.out.println("Data From "+PackFile+" Unpacked Sucessfully." );
               
               
            
    }
    catch(Exception E)
    {
       System.out.println("Error Occured:"+E);
    }    
    return bRet;
  }
}

//////////////////////////////////////////
/// 
/// Main Class (Contains Main Method)
////////////////////////////////////////

public class Main
{
    public static void main(String[] sargs) 
    {
        String DirName=null;
        String Filename=null;
        Scanner Sobj = null; 
        boolean bRet=false;
        FilePackerUnpacker fpuobj = null;

        Sobj = new Scanner(System.in);
        fpuobj = new FilePackerUnpacker();
        System.out.println("Enter Name Of Directory:");
        DirName=Sobj.nextLine();
        System.out.println("Enter Name Of Packer File:");
        Filename=Sobj.nextLine();
         //File Packing
        bRet=fpuobj.filePacker(DirName,Filename);
        if(bRet==false)
        {
            System.out.println("Error:"+DirName+" Directory is not Present");
            Sobj.close();
            return;
        }

        System.out.println("\nEnter Name Of Packed File:");
        Filename=Sobj.nextLine();

        // Authenticate Packed File Before Unpacking
          bRet = fpuobj.isValidPackedFile(Filename);    
        if(bRet == false)
        {
            System.out.println("Error: Invalid packed file. Authentication Failed.");
            Sobj.close();
            return;
        }
 
        System.out.println("\nFile Authenticated Sucessfully.\n");



        //File Unpacking
        bRet=fpuobj.fileUnpacker(Filename);
        if(bRet==false)
        {
            System.out.println("Error:"+Filename+" is not Present");
        }

        Sobj.close();
        fpuobj=null;
        System.gc();
    }
    
}
