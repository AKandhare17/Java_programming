class Logic
{
    void findLargestDigit(int num)
    {
        int temp=0;
        int iMax=0;
        
        while(num!=0)
        {
            temp=num%10;
            if(temp>iMax)
            {
               iMax=temp;
            }
           num=num/10;
           
            
        }
         System.out.println("Maximum no:"+iMax);

    }
}
public class MaxNo
 {
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.findLargestDigit(83429);

    }
    
}
