class Logic
{
    void findLargestDigit(int num)
    {
        int temp=0;
        int iMin=num%10;
        
        while(num!=0)
        {
            temp=num%10;
            if(temp<iMin)
            {
               iMin=temp;
            }
           num=num/10;
           
            
        }
         System.out.println("Maximum no:"+iMin);

    }
}
public class MinNo
 {
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.findLargestDigit(45872);

    }
    
}
