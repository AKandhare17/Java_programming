//Enum Use Case
public enum School{
    Principle,Teacher,HOD,Lab_Assitant;
  }
public class Enum
{
    public static void main(String sargs[])
    {
      School Sobj= School.Principle;
      System.out.println(Sobj);

      for(School Sobj1: School.values())//iterating over for loop
      {
       // System.out.println(Sobj1);
        System.out.println(Sobj1.ordinal());//returns Enum order
      }

      
    }
}