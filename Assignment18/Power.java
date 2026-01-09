class Logic
{
    void calculatePower(int base,int exp)
    {
        int iCnt=0,imul=1;

        for(iCnt=1;iCnt<=exp;iCnt++)
        {
          imul=base*imul;
        }
    
    System.out.println(base+"**"+exp+":"+imul);
    }

}
public class Power 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.calculatePower(2,5);
    }
    
}
