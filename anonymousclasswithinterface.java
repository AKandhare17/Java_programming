interface anonymous
{
 abstract public void greet();

}//interface

public class anonymousclasswithinterface 
 {

    public static void main(String[] sargs) 
    {
        
    anonymous obj = new anonymous()//object of anonymous class 
    {
        @Override
        public void greet()
        {
           System.out.println("Hello From anonymousclass method");
        }
    };
    //internally 2 class cretaed in .class file
    
    obj.greet();
}
      
}
