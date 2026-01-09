class Logic
{
    void checkPerfect(int num)
    {
        int iCnt=0,iSum=0,temp=num;
        for(iCnt=1;iCnt<=num;iCnt++)
        {
            if(num%iCnt==0)
            {
             iSum=iSum+iCnt;
            }
        }
        if(iSum==temp)
        {
            System.out.println(temp+": is Perfect no.");
        }
        else
        {
                 System.out.println(temp+": not a Perfect no.");
        }
        
    }

}
public class PerfectNo
 {
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.checkPerfect(6);
    }
    
}
