//Enum is Basically A class Extends By Object class
public enum School
{
    Principle,Teacher,HOD,Lab_Assitant;
  } 
public class EnumClass
 {
    public static void main(String[] sargs)
     {
       School sobj = School.Principle;
       System.out.println(sobj.getClass().getSuperclass());  
       
    } 
    
}
