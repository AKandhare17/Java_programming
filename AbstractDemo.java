abstract class Base
{
    public int i,j;
    public int Addition(int a,int b)
    {
        int iAns=0;
        iAns=a+b;
        return iAns;
    }
    abstract public  int Subtraction(int a,int b);
}
public class AbstractDemo 
{
    public static void main(String sargs[])
    {
       // Base bobj = new Base();//Error(Abstract class can't Instantsiated)

    }
    
}
