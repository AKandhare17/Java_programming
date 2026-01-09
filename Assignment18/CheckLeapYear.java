class Logic
{
    public void CheckLeapYear(int Year)
    {
        if(Year%4==0 && Year%100!=0||Year%400==0)
        {

             System.out.println(Year+" is Leap Year");
            
        
        }
        else
        {
            System.out.println(Year+" is Not Leap year");
        }

    }

}
public class CheckLeapYear
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.CheckLeapYear(4000);

    }
}