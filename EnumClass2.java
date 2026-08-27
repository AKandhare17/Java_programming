//Enum is Basically A class Extends By Object class
public enum Laptop
{
    Asus(80000),Dell(54000),Acer,Lenovo(57000),MacBook(140000);

    private int Price;
    
    private Laptop()
    {
      this.Price=12000;//default constructor for laptop with no price(invoked only onced)
    }


    private Laptop(int price)//constuctor invoked 4 times because 4 contannts with price declared(creating object in same class)
    {
      this.Price=price;
    }
      
    public void setter(int price)
    {
      this.Price=price;
    }

    public int getters()
    {
      return this.Price;
    }
    
  } 


public class EnumClass2
 {
    public static void main(String[] sargs)
     {
       Laptop lobj = Laptop.Lenovo;
       System.out.println(lobj+" "+lobj.getters());
       
       for(Laptop lobj2:Laptop.values())
       {
        System.out.println(lobj2+" "+lobj2.getters());
       }
    } 
    
}
