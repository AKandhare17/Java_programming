class Logic
{
    void sumOfEvenNumbers(int n)
    {
        int iCnt=0,iSum=0;
        for(iCnt=1;iCnt<=n;iCnt++)
        {
            if(iCnt%2==0)
            {
           iSum=iSum+iCnt;
            }
        }
         System.out.println("Sum:"+iSum);
    }

}
public class SumOfEven
 {
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.sumOfEvenNumbers(10);
    }
    
}
