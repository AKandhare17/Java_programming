//Enum With Switch
public enum School
{
    Principle,Teacher,HOD,Lab_Assitant;
  }
public class Enum3
{
    public static void main(String sargs[])
    {
      School Sobj= School.Lab_Assitant;
      
     switch (Sobj)
      {
      case Principle:
        System.out.println("Person is Principle");
        break;

        case Teacher:
          System.out.println("Person is Teacher");
          break;

        case HOD:
          System.out.println("Person is HOD");
          break;

          case Lab_Assitant:
            System.out.println("Person is Lab_Assistant");
            break;
          
          default:
        System.out.println("Person Not Present");
        break;
     }

      
    }
}