class Logic
{
    public void displayFactors(int num)
    {
    int iCnt=0;
    for(iCnt=1;iCnt<num/2;iCnt++)
    {
        if(num%iCnt==0)
        {
            System.out.print(iCnt);
        }
    }
    }
}
public class FactorOfNo 
{
    public static void main(String sargs[])
    {
    Logic lobj = new Logic();
    lobj.displayFactors(12);
    }
    
}
