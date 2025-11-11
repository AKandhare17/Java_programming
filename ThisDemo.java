class Demo
{
    public int i;
    public  static int j;
    static
    {
        j=21;

    } 
    public Demo()
    {
        System.out.println("Inside Default Constructor");
        this.i=11;
    }
    public Demo(int a)
    {
        this();
        System.out.println("Inside parameterised ");
    }
    public void Display()
    {
        System.out.println("inside Display()"+this.i);
    }

}
public class ThisDemo 
{
    public static void main(String sargs[])
    {
        Demo dobj = new Demo();
        dobj.Display();

    }
    
}
