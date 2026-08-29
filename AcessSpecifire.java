class Base 
{
    public int ia;
    private float fa;
    protected double da;
    Base()
    {
        this.ia=0;
        this.fa=0.0f;
        this.da=0.0;
    }

    public void BaseDisplay()
    {
        System.out.println("value of public int ia:"+ia);
        System.out.println("value of private float fa:"+fa);
        System.out.println("value of protected int da:"+da);
    } 
    
}
class Derived extends Base
{
    Base bobj = new Base();
    
        System.out.println("value of public int dobj.fa:"+bobj.fa);
        
    
    public void DerivedDisplay()
    {
        System.out.println("value of public int bobj.ia:"+ibobj.a);
        System.out.println("value of private float bobj.fa:"+bobj.fa);
        System.out.println("value of protected int bobj.da:"+bobj.da);

    }
    


}

class AcessSpecifire
{
    public static void main(String sargs[])
    {
       int a;

      Derived dobj = new Derived();
      Derived bobj = new Base();

       bobj.BaseDisplay();
       dobj.DerivedDisplay();



      System.out.println("value of public int bobj.ia:"+ibobj.a);
        System.out.println("value of private float bobj.fa:"+bobj.fa);
        System.out.println("value of protected int bobj.da:"+bobj.da);
        
        System.out.println("value of public int dobj.ia:"+dobj.ia);
        System.out.println("value of private float dobj.fa:"+dobj.fa);
        System.out.println("value of protected int dobj.da:"+dobj.da);
    } 

    
}