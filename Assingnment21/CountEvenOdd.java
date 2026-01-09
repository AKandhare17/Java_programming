class Logic
{
    void countEvenOddRange(int n)
    {
        int iCnt=0,iCount=0,iCount1=0;
        for(iCnt=0;iCnt<n;iCnt++)
        {
            if(iCnt%2==0)
            {
                iCount++;
            }
            else{
                iCount1++;
            }
        }
        System.out.println("Even count:"+iCount+"\tOdd Count:"+iCount1);
        
    }

}
public class CountEvenOdd 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.countEvenOddRange(50);
    }
    
}
