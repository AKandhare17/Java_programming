class Logic
{
    void printOddNumbers(int n)
    {
        int iCnt=0;
        for(iCnt=0;iCnt<n;iCnt++)
        {
            if(iCnt%2!=0)
            {
            System.out.println(iCnt+"\t");
            }
        }

    }

}
public class PrintOdd
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.printOddNumbers(20);

    }
    
}
