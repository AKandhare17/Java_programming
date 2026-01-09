class Logic 
{
    void printDigits(int num)
    {
        int iMod=0;
        while(num!=0)
        {
            iMod=num%10;
            num=num/10;
           System.out.println(iMod); 
        }

    }
}
public class DigitOfNum 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.printDigits(9876);

    }
    
}
