package Recursion;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Ente the Non- Negative Integer : ");
        long n = input.nextLong();
        System.out.println("The Factorial of the Given Number : "+ factorial(n));
    }
    public static long factorial(long n){
        if(n == 0)
            return 1;
        return n* factorial(n-1);
    }
}
