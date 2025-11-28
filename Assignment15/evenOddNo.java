class Logic
{
    public void checkEvenOdd(int num)
    {
    
    if(num%2==0)
    {
        System.out.println(num+" is Even");
    }
    else
    {
           System.out.println(num+" is Odd");
    }
   
    }
}
public class evenOddNo 
{
    public static void main(String sargs[])
    {
          Logic lobj= new Logic();
          lobj.checkEvenOdd(7);
    }
    
}
