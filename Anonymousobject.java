class test
{
    public test()
    {
        System.out.println("Test Constructor invoked ");
    }
    public void display()
    {
        System.out.println("Hello From Test Display");
    }

}
public class Anonymousobject
{
    public static void main(String sargs[])
    {
        new test();//anonymous object
        new test().display();

    }
}