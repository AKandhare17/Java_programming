abstract class Base
{
    public int i,j;
    public int Addition(int a,int b)
    {
        return a+b;
    }
    abstract public int Substraction(int a,int b);
}

class Derived extends Base
{
    public int Substraction(int a,int b)
    {
        return a-b;
    }
    public int Multiplication(int a,int b)
    {
        return a*b;
    }

}
public class AbstractDemo3
 {
    public static void main(String sargs[])
    {
        Base bp =new Derived();
        int iRet=0;
        iRet=bp.Addition(2,6);
        System.out.println("Addition is :"+iRet);
        iRet=bp.Substraction(5,8);
        System.out.println("Substraction is:"+iRet);
         //iRet=bp.Multiplication(5,8);//Error

    }
    
}
