// Java does not support concept of Destructor due to automatic garbage collection policies
class c1
{
 
 public c1()
 {
    System.out.println("Inside default constructor\n");// Deafault constructor
 }

 public c1(int a)
 {
    System.out.println("Inside Parameterised  constructor\n");// parametrised constructor
 }

 protected void finalize()
 {
    System.out.println("Inside finalise method.");// Finalize method 
 }

}
class GarbageCollector
{
    public static void main(String sargs[])
    {
        c1 c1obj = new c1();//Implicit call to default constructor
        c1 c1obj1 = new c1(3);//Implicit call to parametrised constructor

        System.out.println("End of main");


         c1obj=null;i//nitialising null (memory empty)
         c1obj1=null;// initialising null (memory empty)

        System.gc();//explicit call to Automatic Garbage collector with help of finalize()(static)
        
    }
}