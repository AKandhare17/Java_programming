class Logic
{
    public void countFactor(int num)
    {
    int iCnt=0,iCount=0;
    for(iCnt=1;iCnt<num/2;iCnt++)
    {
        if(num%iCnt==0)
        {
            
            iCount++;
        }
    }
    System.out.print("Count of factors:"+iCount);
    }
}
public class countFactors
{
    public static void main(String sargs[])
    {
    Logic lobj = new Logic();
    lobj.countFactor(12);
    }
    
}
