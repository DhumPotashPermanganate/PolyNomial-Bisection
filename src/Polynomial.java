import java.util.Scanner;

public class Polynomial
{

    public static int[] degarr= new int[6];
    public static int highest_degree;
    public static double a , b ;

    static final float EPSILON = (float)0.01;



    static double func(double x)
    {
        double val=0;
        for(int i=highest_degree; i>=0;i--)
        {
            val= val+ degarr[i]*Math.pow(x, i);
        }
        return val;
        //return 2*x*x*x*x*x - 15*x*x*x*x + 35*x*x*x - 15*x*x -37*x +30;
    }

    // Prints root of func(x) with error of EPSILON
    static void bisection(double a, double b)
    {
        if (func(a) * func(b) >= 0)
        {
            System.out.println("You have not assumed right a and b");
            return;
        }

        double c = a;
        while ((b-a) >= EPSILON)
        {
            // Find middle point
            c = (a+b)/2;

            // Check if middle point is root
            if (func(c) == 0.0)
                break;

                // Decide the side to repeat the steps
            else if (func(c)*func(a) < 0)
                b = c;
            else
                a = c;
        }
        //prints value of c upto 4 decimal places
        System.out.printf("\nThe value of root is : %.4f",c);
    }

    public static void readpoly()
    {
        System.out.println("What is the highest degree of your polynomial? ");
        Scanner input = new Scanner(System.in);
        highest_degree = input.nextInt();
        for(int i= highest_degree; i>=0; i--)
        {
            System.out.println("Enter the coffecient of you x^"+i);
            degarr[i]= input.nextInt();
        }

        System.out.println("Your Polynomial is: ");
        for(int i= highest_degree; i>=0; i--)
        {
            if (degarr[i]<0 && i!=0)
                System.out.print(degarr[i]+"x^"+i+" ");
            if(degarr[i]>0 && i!=0)
                System.out.print("+"+degarr[i]+"x^"+i+" ");
            if(degarr[i]>0 && i==0)
                System.out.print("+"+degarr[i]+" ");
            if(degarr[i]<0 && i==0)
                System.out.print("-"+degarr[i]+" ");
        }
    }

    public static void findAB()
    {
        for(double i=-5; i<=5; i=i+0.1)
        {
            if(func(i)<0)
                a= i;
            if(func(i)>0)
                b= i;
            if (func(a) * func(b) < 0)
                bisection(a, b);

        }
    }


    public static void main(String[] args)
    {
        readpoly();
        findAB();
        //bisection(a, b);
    }

}

