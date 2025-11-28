class Logic
{
    void printEvenNumbers(int n)
    {
        int iCnt=0;
        for(iCnt=0;iCnt<n;iCnt++)
        {
            if(iCnt%2==0)
            {
            System.out.println(iCnt+"\t");
            }
        }

    }

}
public class PrintEven 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.printEvenNumbers(20);

    }
    
}
