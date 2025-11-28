class Logic
{
    void reverseNumber(int num)
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
public class noReverse 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.reverseNumber(1234);

    }
    
}
