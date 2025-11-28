

class Logic
{
  public void  sumOfDigits(int num)
    {
        int iMod=0,iSum=0;
        if(num<0)
        {
            num =-num;
        }
        while(num!=0)
        {
        iMod=num%10;
        iSum+=iMod;
        num = num/10;

        }
        System.out.println("Sum of Digits:"+iSum);


    }


}
public class SumOfDigits
 {
    public static void main(String[] args) 
    {
        Logic lobj = new Logic();
        lobj.sumOfDigits(1234);
    }
    
}
