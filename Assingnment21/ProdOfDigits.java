class Logic
{
    int iMul=1;
    int temp=0;
    void productOfDigits(int num)
    {
        while(num!=0)
        {
        temp=num%10;
        iMul=iMul*temp;
        num=num/10;
        }
        System.out.print("Product of Digits:"+iMul);


    }
}
public class ProdOfDigits
{
    public static void main(String sargs[])
    {
      Logic lobj = new Logic();
      lobj.productOfDigits(234);

    }
}