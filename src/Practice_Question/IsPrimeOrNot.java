package Practice_Question;

import java.util.Scanner;

public class IsPrimeOrNot {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the NUmber For Checking the Prime Or Not : ");
        int number = scanner.nextInt();

        System.out.println("The Given NUmber is "+ IsPrime(number));

    }
    public static String IsPrime(int n){
        if(n<= 1){
            return "undefined";
        }
        int temp =2;
        while(temp*temp <= n){
            if(n % temp== 0){
                return "Not a Prime Number";
            }
            temp++;
        }
        return " Prime Number ";
    }
}
