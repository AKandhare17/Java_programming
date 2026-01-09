class Logic
{
    void printReverse(int n)
    {
        int iCnt=0;
        for(iCnt=n;iCnt>=1;iCnt--)
        {
            System.err.println(iCnt);
        }

    }
}
public class PrintReverse 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.printReverse(10);

    }
    
}
