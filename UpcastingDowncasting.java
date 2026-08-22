class Base
{
    public Base()
    {
        System.out.println("Inside base constructor");
    }
    public void basemethod()
    {
       System.out.println("Inside base class method"); 
    }
}
class Derived extends Base
{
     public Derived()
    {
        System.out.println("Inside Derived constructor");
    }
    public void derivedmethod()
    {
       System.out.println("Inside derived class method"); 
    }

}
public class UpcastingDowncasting 
{
    public static void main(String sargs[])
    {
        Base obj = new Derived();
        //internally Base obj = (Base) new Derived();
        obj.basemethod();
        

      //  Derived obj1 = new Base();
        //internally Derived obj1 = (Derived) new  Base();
      //throws error

         Derived dobj = (Derived) obj;//typecasting obj with Derived class
         dobj.basemethod();
         dobj.derivedmethod();
         //no overloading still call both methods
    }
    
}
