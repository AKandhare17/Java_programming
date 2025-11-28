class Logic
{
    public void checkPalindrom(int num)
    {
        int iReverse=0,tempnum=num;
      
        
        while(num!=0)
        {
                                              //input:363 (tempnum=363)
             iReverse=(iReverse*10)+(num%10); //No reversing logic:
                                              // (363%10=3)+(10*0=0)    ,iReverse=3      ,num=36(363/10)
             num=num/10;                     //(36%10=6)+(10*3=30)        ,iReverse=36   ,num=3(36/10)
                                             //(3%10=3)+(10*36=360)      ,iReverse=363  ,num=0(3/10)
            
        }
        if(tempnum==iReverse)
        {
            System.out.println(iReverse+"  is Palindrim no");
        }
    }

}

public class CheckPalindrom 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.checkPalindrom(363);


    }
    
}
