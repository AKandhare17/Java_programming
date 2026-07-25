abstract class Base
{
    public int i,j;
    public int Addition(int a,int b)
    {
        int iAns=0;
        iAns=a+b;
        return iAns;
    }
    abstract public int Substraction(int a,int b);
}
class Derived extends Base
{
    public int Substraction(int a,int b)
    {
       int  iAns=0;
        iAns=a-b;
        return iAns;
    }
    public int Multiplication(int a,int b)
    {
        int iAns=0;
        iAns=a*b;
        return iAns;
    }


}

public class AbstractDemo2
{
    public static void main(String sargs[])
    {
        
        Base bp = new Derived();  
        int iRet = 0;

        iRet = bp.Addition(11,10);
        System.out.println(iRet);

        iRet = bp.Substraction(11,10);
        System.out.println(iRet);

        //iRet = bp.Multiplication(11,10);      // Error(method is from class Derived)
      

    }
    
}
