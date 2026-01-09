class Logic
{
    public void printDivisibleBy2and3(int n)
    {
    int iCnt=0;
    for(iCnt=1;iCnt<n;iCnt++)
    {
        if((iCnt%2==0)&&(iCnt%3==0))
        {
            
         System.out.println(iCnt);
        }
    }
   
    }
}


public class NoDivisibleBy2and3
 {
     public static void main(String sargs[])
    {
    Logic lobj = new Logic();
    lobj.printDivisibleBy2and3(30);
    }
    
}
