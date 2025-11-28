class Logic
{
    public void calculateSum(int iNo)
    {
        int iSum=0,iCnt=0;
        if(iNo<0)
        {
            iNo=-iNo;
        }
        for(iCnt=1;iCnt<iNo;iCnt++)
        {
           iSum+=iCnt;
        }
     System.out.println("Sum:"+iSum);
        }

}
public class sumOfNaturalNo
{
    public static void main(String []sargs)
    {
        Logic lobj = new Logic();
        lobj.calculateSum(10);
    }


}