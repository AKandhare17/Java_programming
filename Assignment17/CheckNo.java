
class Logic
{
    public void checkSign(int num)
    {
        if(num==0)
        {
            System.out.println(num+"is Zero");
        }
        else if(num>0)
        {
         System.out.println(num+"is Positive");   
        }
        else
        {
            System.out.println(num+"is Negative");
        }
    }
} 
public class CheckNo 
{
    public static void main(String sargs[])
    {
    Logic lobj = new Logic();
    lobj.checkSign(-3);
    }
    
}
