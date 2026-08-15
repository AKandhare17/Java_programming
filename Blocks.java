class Demo
{
    public int i;
    static public int j;

    static
    {
     System.out.println("inside Static Block");
      j=21;
    }
    public Demo()
    {
      System.out.println("Inside Default constructor of Demo");
      this.i=11;
    }

}
public class Blocks
 {
    public static void main(String sargs[])
    {
        System.out.println("Inside Main()");
        Demo dobj = new Demo();
         Demo dobj1 = new Demo();
          Demo dobj2 = new Demo();


    }
    
}
