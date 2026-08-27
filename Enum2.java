//Enum With If Else
public enum School
{
    Principle,Teacher,HOD,Lab_Assitant;
  }
public class Enum2
{
    public static void main(String sargs[])
    {
      School Sobj= School.Lab_Assitant;
      
    if(Sobj==Sobj.Principle)
    {
      System.out.println("Person is Principle");
    }
    else if(Sobj==Sobj.Teacher)
    {
       System.out.println("Person is Teacher");
    }
    else if(Sobj==Sobj.HOD)
      {
         System.out.println("Person is HoD");
      }  
      else if(Sobj==Sobj.Lab_Assitant)
      {
         System.out.println("Person is Lab Assistance");
      }
      else
      {
         System.out.println("Person Not Present");
      }

      
    }
}