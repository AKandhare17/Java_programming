class Demo
{
    public int i;
    static public int j;

    static
    {
     System.out.println("inside Static Block");//Executes only once
     
      j=21;
    }

    {
      System.out.println("inside Initializer Block"); //Initialiser block(for non static charecteristics)

    }

    public Demo()
    {
      System.out.println("Inside Default constructor of Demo");
      this.i=11;
    }

    public Demo(int a)
    {
        System.out.println("Inside parameterised constructor of Demo");
        this.i=a;

    }

}
public class BlocksX
 {
    public static void main(String sargs[])
    {
        System.out.println("Inside Main()");
        Demo dobj = new Demo();
         Demo dobj1 = new Demo();
          Demo dobj2 = new Demo();
          Demo dobj3 = new Demo(5);


    }
    
}
