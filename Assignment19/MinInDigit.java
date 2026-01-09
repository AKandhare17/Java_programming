class Logic
{
    void findSmallestDigit(int num)
    {
     int iMod=0,iMin=num;
     while(num!=0)
     {
        iMod=num%10;
        
        if(iMin>iMod)
        {
            iMin=iMod;
        }
        num=num/10;
        
        
        
     }
     System.out.println("Maximum no is:"+iMin);
    }
}
public class MinInDigit 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.findSmallestDigit(45872);

    }
    
}
