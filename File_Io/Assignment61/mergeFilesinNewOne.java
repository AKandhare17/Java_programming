import java.util.Scanner;
import java.io.*;
public class mergeFilesinNewOne
{
    public static void main(String[] sargs) throws Exception
    {
        String Fname2=null,Fname=null;
        char info[]={' '};
        File fobj=null,fobj2=null,fobj3=null;
        FileWriter fwobj=null,fwobj2=null;
        FileReader frobj=null,frobj2=null;
        Scanner sobj = new Scanner(System.in);
        System.out.println("Enter Name of First File");
        Fname=sobj.nextLine();
        System.out.println("Enter Name of Second File");
        Fname2=sobj.nextLine();

    fobj = new File(Fname);
    fobj2 = new File(Fname2);
    fobj3 = new File("Merged.txt");

    if(fobj.exists()==false)
    {
        System.out.println(Fname+"not exits");
        sobj.close();
        return;
    }

     if(fobj2.exists()==false)
    {
        System.out.println(Fname2+"not exits");
        sobj.close();
        return;
    }

    frobj = new FileReader(fobj);
     fwobj = new FileWriter(fobj3);
    while (frobj.read(info)!=-1)
     {
        fwobj.write(info);
    }
     
    frobj2 = new FileReader(fobj2);
      fwobj2 = new FileWriter(fobj3,true);
     while (frobj2.read(info)!=-1)
     {
        fwobj2.write(info);
     }
   
   System.out.println("Data From "+Fname+" to "+Fname2+" Merged into Merged.txt");

    fwobj.close();
    frobj.close();
     frobj2.close();
     fwobj2.close();
    fobj=null;
    sobj.close();

    }
    
}
