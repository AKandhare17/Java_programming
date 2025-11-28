class Logic 
{
    public void findMin(int a, int b, int c)
    {
        if(a<b&&a<c)
        {
            System.out.println(a+" is Minimum.");
        }
        else if(b<c)
        {
            System.out.println(b+" is Minimum.");
        }
        else
        {
            System.out.println(c+" is minimum.");
        }
    }
}
public class MinimumOf3 
{
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.findMin(35,4,8);
    } 
    
}
