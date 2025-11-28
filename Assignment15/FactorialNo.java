class Logic
{
    public void findFactorial(int num)
    {
        int iCnt=0,iFact=1;
        for(iCnt=num;iCnt>=1;iCnt--)
        {
            iFact*=iCnt;
        }
        System.out.println("Factorial  of "+num+" is:"+iFact);
    }
}
public class FactorialNo 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.findFactorial(5);
    }
    
}
