class Logic
{
    void findLargestDigit(int num)
    {
     int iMod=0,iMax=1;
     while(num!=0)
     {
        iMod=num%10;
        if(iMax<iMod)
        {
            iMax=iMod;
        }
        num=num/10;
        
        
        
     }
     System.out.println("Maximum no is:"+iMax);
    }
}
public class MaxInDigit 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.findLargestDigit(87358);

    }
    
}
