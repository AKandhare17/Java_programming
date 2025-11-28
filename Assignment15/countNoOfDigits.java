class Logic
{
    public void countDigits(int num)
    {
        int iMod=0,iCount=0;
        while(num!=0)
        {
            iMod=num%10;
            iCount++;
            num=num/10;
        }
        System.out.println("No of Digits:"+iCount);
    }

}
public class countNoOfDigits 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.countDigits(79788);
    }
}
