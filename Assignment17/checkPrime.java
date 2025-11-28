class Logic
{
    void checkPrime(int num)
    {
        if((num%num==0)&&(num%1==0))
        {
            System.out.println(num+"is prime No.");
        }
        else
        {
          System.out.println(num+"is not a prime no.");
        }

    }

}
public class checkPrime
{
    public static void main(String sargs[])
    {
    Logic lobj = new Logic();
    lobj.checkPrime(11);
    }

}