package Recursion;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("Enter the Index to get the Fibonacci Number : ");
        long index = input.nextLong();
        System.out.println("The Fibonacci Number : "+ fibonacci(index));
    }

    public static long fibonacci(long index){
        if(index == 0)
            return 0;
        if (index ==1)
            return 1;
        return  fibonacci(index-1)+fibonacci(index-2);
    }
}
