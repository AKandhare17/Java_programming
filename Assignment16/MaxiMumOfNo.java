class Logic
{
    public void findMax(int a, int b)
    {
        if(a<b)
        {
            System.out.println(b+" is maximum No.");
        }
        else
        {
          System.out.println(a+" is maximum No.");

        }

    }

}
public class MaxiMumOfNo
 {
    public static void main(String sargs[])
    {
        Logic lobj = new Logic();
        lobj.findMax(20,25);

    }

    
}
