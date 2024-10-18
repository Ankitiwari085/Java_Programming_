package Exception_Handling;

import java.util.Scanner;

public class test1 {


    public static void main(String[] args) {
//
//        Scanner input =new Scanner(System.in);
//         int a= input.nextInt();
//         int b= input.nextInt();
//
//        try{
//            int result =quotient(a,b);
//            System.out.println(result);
//        }
//        catch (ArithmeticException ex){
//            System.out.println(ex);
//        }
//
//    }
//
//    public static int quotient (int a,int b){
//        if (b==0){
//            throw new ArithmeticException("Divisior Can't Be Zero");
//
//        }
//        return a/b;
//    }

    Scanner input =new Scanner(System.in);
    float a= input.nextFloat();
    float b= input.nextFloat();
        try{
        float result =quotient(a, b);
        System.out.println(result);
    }
        catch (ArithmeticException ex){
        System.out.println("Arithmetic Exception : The Number Can't be Divisible by Zero.");
    }

}

public static float quotient (float a,float b){
    if (b == 0.0){
        throw new ArithmeticException("Divisior Can't Be Zero");

    }
    return a/b;
}
}
