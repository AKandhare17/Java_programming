class Logic
{
    void displayGrade(int Marks)
    {
        if(Marks<=100&&Marks>=70)
        {
          System.out.println("Grade A");
        }
        
        else if(Marks<70&&Marks>=50)
        {
          System.out.println("Grade B");
        }
     else if(Marks<=35)
        {
           System.out.println("Grade C");
        }
        
        else
        {
            System.out.println("Grade F");
        }
        

    }
}
public class GradeChecker 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.displayGrade(82);

    }
    
}
