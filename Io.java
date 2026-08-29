import java.util.Scanner;// Scanner is class in util package for output purpose
class Io
{
    public static void main(String sargs[])
    {
        Scanner scobj = new Scanner(System.in);// making object of class Scanner 
        int ia=0,ib=0;
        System.out.println("Enter two no's for addition:");
        ia=scobj.nextInt();//Reading input with help of Scanner object
        ib=scobj.nextInt();//Reading input with help of Scanner object

        System.out.println("Addition:"+(ia+ib));
    
    }

}