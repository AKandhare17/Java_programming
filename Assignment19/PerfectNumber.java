class Logic
{
    void checkPerfect(int num)
    {
        int temp=num,iCnt=0,iperfect=0;
        for(iCnt=1;iCnt<=num/2;iCnt++)
        {
            if(num%iCnt==0)
            {
              iperfect=iCnt+iperfect;
            }
        }
        if(iperfect==temp)
        {
            System.out.println(temp+" is Perfect Number");
        }
        else
        {
                  System.out.println(temp+" is Not  Perfect Number");
        }

    }
}
public class PerfectNumber 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.checkPerfect(28);

    }
    
}
