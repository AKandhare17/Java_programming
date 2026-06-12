import java.util.*;
import  java.time.LocalDateTime;
import java.time.LocalDate;
import java.io.*;


///////////////////////////////////////////////////////////////////
/// 
/// Student Study Tracker
/// 
///////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////
/// 
/// StudyLog class
/// 
/////////////////////////////////////////////////////////////////
class StudyLog
{
   private LocalDate Date;
  private String Subject;
  private double Duration;
  private String Description;
 

  public StudyLog(LocalDate a,String b, double c, String d)
  {
    this.Date=a;
    this.Subject=b;
    this.Duration=c;
    this.Description=d;
  }

  public LocalDate getDate()
  {
    return this.Date;
  }

   public String getSubject()
  {
    return this.Subject;
  }

   public double getDuration()
  {
    return this.Duration;
  }

   public String getDescription()
  {
    return this.Description;
  }

  @Override
  public String toString()
  {
    return "|"+Date+" | "+Subject+" | "+Duration+" | "+Description+"|";
  }

}

///////////////////////////////////////////////////////////////////
/// 
/// StudyTracker Class
/// 
///////////////////////////////////////////////////////////////
class StudyTracker
{
   public ArrayList<StudyLog> database = new ArrayList<StudyLog>();

   

///////////////////////////////////////////////////////////////////
/// 
/// function name:insertLog() 
/// info:Inserts Study Details 
/// Authour: Atharva vasant Kandhare
/// 
///////////////////////////////////////////////////////////////
   public void insertLog()
   {
    Scanner sobj = new Scanner(System.in);
    String Sub=null,Des=null;
    double Duration=0.0;

    System.out.println("-----------------------------------------------------");
     System.out.println("-----------Enter Valid Detais Of Your Study----------");
      System.out.println("-----------------------------------------------------");

      LocalDate Dateobj = LocalDate.now();
      System.out.println("Please Enter Name Of Subject:");
      Sub=sobj.nextLine();
      System.out.println(" Enter Time Period Of Your Study(Hrs):");
      Duration=sobj.nextDouble();
      sobj.nextLine();
      System.out.println("Enter Description Of Study:");
      Des=sobj.nextLine();

      StudyLog studyobj = new StudyLog(Dateobj, Sub, Duration, Des);

      database.add(studyobj);

      System.out.println("Data Gets Stored Sucessfully.........");
      System.out.println("-----------------------------------------------------");

sobj.close();
   }


//////////////////////////////////////////////////////////////////////
/// 
/// function name:displayLog() 
/// info:Display Study Details  of Student
/// Authour: Atharva vasant Kandhare
/// 
/////////////////////////////////////////////////////////////////////
   public void displayLog()
   {
    System.out.println("-----------------------------------------------------");
    if(database.isEmpty())
    {
      System.out.println("-------------Nothing To Display(Empty)--------------");
      System.out.println("-----------------------------------------------------");
      return;
    }

    System.out.println("-------------Log Report Of StudyTracker:-------------");
    System.out.println("-----------------------------------------------------");

    for(StudyLog s: database)
    {
      System.out.println(s);
    }
    System.out.println("-----------------------------------------------------");

   }

//////////////////////////////////////////////////////////////////////
/// 
/// function name:exportToCSV() 
/// info:Export Details Of Student To CSV File
/// Authour: Atharva vasant Kandhare
/// 
/////////////////////////////////////////////////////////////////////
   public void exportToCSV()
   {
    String FileName=null;
     if(database.isEmpty())
    {
      System.out.println("-----------------------------------------------------");
      System.out.println("-------------Nothing To Export(Empty)--------------");
      System.out.println("-----------------------------------------------------");
      return;
    }
    FileName="StudentStudyTracker.csv";

    try(FileWriter fwobj = new FileWriter(FileName))
    {
      fwobj.write("Date,Subject,Duration,Description\n");

      for(StudyLog s: database)
      {
        fwobj.write(s.getDate().toString()+","+s.getSubject().replace(","," ")+","+s.getDuration()+","+s.getDescription().replace(","," ")+"\n");
      }
      System.out.println("Data Gets Exported In "+FileName+" Sucessfully....");

    }
    catch(Exception E)
    {
      
      System.out.println("Exception Occured In Csv Handeling"+E);
    }


   }


//////////////////////////////////////////////////////////////////////
/// 
/// function name:SummaryBySubject() 
/// info: Get Study Details Based on Subject 
/// Authour: Atharva vasant Kandhare
/// 
/////////////////////////////////////////////////////////////////////
   public void SummaryBySubject()
   {
    String S=null;
    double d=0.0,old=0.0;

    


     System.out.println("-----------------------------------------------------");
     if(database.isEmpty())
     {
      System.out.println("---------------Nothing To Display(Empty)----------");
       System.out.println("-----------------------------------------------------");
      return;
     }
      System.out.println("::Summary By Subject From StudyTracker::");
      System.out.println("-----------------------------------------------------");

      TreeMap<String,Double> tobj = new TreeMap<String,Double>();

      for(StudyLog sobj: database)
      {
        S=sobj.getSubject();
        d=sobj.getDuration();
        if(tobj.containsKey(S))
        {
         old=tobj.get(S);
         tobj.put(S,d+old);

        }
        else
        {
          tobj.put(S,d);
        }
        
      }

      //Display Details per Subject
      for(String str:tobj.keySet())
      {
            System.out.println("Subject:"+str+" Total Study Duration:"+tobj.get(str));
      }
     System.out.println("-----------------------------------------------------");

}

//////////////////////////////////////////////////////////////////////
/// 
/// function name:SummaryByDate() 
/// info:Get Study Summary Based  On Date
/// Authour: Atharva vasant Kandhare
/// 
/////////////////////////////////////////////////////////////////////
    public void SummaryByDate()
   {
    LocalDate lobj=null;
    double d=0.0,old=0.0;

    


     System.out.println("-----------------------------------------------------");
     if(database.isEmpty())
     {
      System.out.println("---------------Nothing To Display(Empty)----------");
       System.out.println("-----------------------------------------------------");
      return;
     }
      System.out.println("::Summary By Date From StudyTracker::");
      System.out.println("-----------------------------------------------------");

      TreeMap<LocalDate,Double> tobj = new TreeMap<LocalDate,Double>();

      for(StudyLog sobj: database)
      {
        lobj=sobj.getDate();
        d=sobj.getDuration();
        if(tobj.containsKey(lobj))
        {
         old=tobj.get(lobj);
         tobj.put(lobj,d+old);

        }
        else
        {
          tobj.put(lobj,d);
        }
        
      }

      //Display Details per Date
      for(LocalDate l:tobj.keySet())
      {
            System.out.println("Date:"+l+" Total Study Duration:"+tobj.get(l));
      }
     System.out.println("------------------------------------------------------");

     
   }



}



//////////////////////////////////////////////////////////////////////
/// 
/// StudentStudy Tracker(main class) 
/// 
/////////////////////////////////////////////////////////////////////
public class StudentStudyTracker
{
  public static void main(String sargs[]) 
  {
    Scanner sobj = new Scanner(System.in);
    StudyTracker stobj = new StudyTracker();
    int iChoice=0;
    //App Baner
    System.out.println("-----------------------------------------------------");
    System.out.println("--------Welcome To Study Tracker-----------");
    System.out.println("-----------------------------------------------------");
    do
    {
      System.out.println("Please select Appropriate Option:");
      System.out.println("1.Insert New StudyLog");
       System.out.println("2.View All  StudyLog");
        System.out.println("3.Export Study Log To CSV file");
         System.out.println("4.Summary Of StudyLog by Date");
          System.out.println("5.Summary Of StudyLog by Subject");
           System.out.println("6.EXIT");
           iChoice=sobj.nextInt();

           switch (iChoice) {
            //inset new StudyLog
            case 1:
                  stobj.insertLog();
                  break;
            //view All StudyLog
           case 2:
                   stobj.displayLog();
                   break;
            //Export data to CSV       
            case 3:
                   stobj.exportToCSV();
                    break;
            //Summary of study log by date
            case 4:
                   stobj.SummaryByDate();
                   break;
            //summary of study log by subject       
            case 5:
                    stobj.SummaryBySubject();
                   break;
             //EXIT             
             case 6:
               System.out.println("-----------------------------------------------------");
               System.out.println("------------------------Thank You!--------------------");
                     break;                
            default:
               System.out.println("Invalid Choice!");
                 System.out.println("Please Enter Valid Choice");
              break;
           }

    }while(iChoice!=6 );//end of do while
     sobj.close();

  }//end of main()
    
      

    
}//end of starter class (main class)

