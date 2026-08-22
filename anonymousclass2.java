abstract class anonymousDemo
{
 public anonymousDemo()
 {
    System.out.println("Hello From anonymousDemo constructor");
 }

 abstract public void greet();
}//abstarct class 

public class anonymousclass2
 {

    public static void main(String[] sargs) 
    {
        
    anonymousDemo obj = new anonymousDemo()//object of anonymous class 
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
