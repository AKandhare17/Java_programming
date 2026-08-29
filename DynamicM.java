import java.util.Scanner;
//java follows automatic garbage collection policy due to that we dont need to free memory
class DynamicM
{
    public static void main(String sargs[])
    {
        Scanner scobj=new Scanner(System.in);
        int ilength=0;
         //Step 1:Allocate memory dyanamically
        int iArr[] = new int[ilength];
        if(iArr==null)
        {
            System.out.println("memory allocation unsucessfull.");
        }
        else
        {
            System.out.println("Memory allocated sucessfully.");
        }

         //step 2:Use allocated memory
        System.out.println("Length of iArr:"+iArr.length);

        iArr =null;//refering null to object 

// step 3:free allocated memory
        System.gc();//explicit call to Garbage collector

    }
}