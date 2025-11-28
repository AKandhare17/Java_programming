class Logic
{
    void sumEvenOddDigits(int num)
    {
        int iSumE=0,iSumO=0,iMod=0;
        while(num!=0)
        {
            iMod=num%10;
            if(iMod%2==0)
            {
                iSumE+=iMod;
            }
            else
            {
                 iSumO+=iMod;
            }
            num=num/10;
        }

    
    System.out.println("Addition of Even:"+iSumE);
    System.out.println("Addition of Odd:"+iSumO);
    }   
}
public class PrintOddEvenSum
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.sumEvenOddDigits(123456);

    }
    
}
