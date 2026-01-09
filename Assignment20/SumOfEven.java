class Logic
{
    void sumEvenNumbers(int n)
    {
       int iCnt=0,iSum=0;
       for(iCnt=0;iCnt<n;iCnt++)
       {
          iSum+=iCnt;
       }
      System.out.println("Sum of Even: "+iSum);
    }
}

public class SumOfEven
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.sumEvenNumbers(10);

    }
}