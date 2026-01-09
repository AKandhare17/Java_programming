class Logic
{
    void checkDivisible(int num)
    {
        if(num%5==0 && num%11==0)
            
            {
                System.out.println(num+" is Divisible by 5 And 11");
            }
            else
            {
             System.out.println(num+" is Not Divisible by 5 And 11");
            }
    }
}
public class NoDivisibleBy5Or11 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.checkDivisible(55);
    }
    
}
