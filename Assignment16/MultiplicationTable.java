class Logic
{
    public void printTable(int iNo)
    {
        int iCnt=0;
        for(iCnt=1;iCnt<=10;iCnt++)
        {
            System.out.println(iNo+" * "+iCnt+" = "+iCnt*iNo);
        }
    }

}
public class MultiplicationTable 
{
    public static void main(String Sargs[])
    {
        Logic lobj = new Logic();
        lobj.printTable(5);

    }
}
