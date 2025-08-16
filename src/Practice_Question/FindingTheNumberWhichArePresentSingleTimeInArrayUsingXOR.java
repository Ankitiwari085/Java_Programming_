package Practice_Question;

import java.util.Scanner;

public class FindingTheNumberWhichArePresentSingleTimeInArrayUsingXOR {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = new int[5];  //  [1,2,3,2,1]
        System.out.println("Enter the Numbers in the Array of Size 5");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter the number : ");
            numbers[i]= scanner.nextInt();
        }
        System.out.println("The Number occur single time in the List is "+ TestingNumber(numbers)); // result  = 3

    }

    public static int TestingNumber(int[] numbers){
        int result=0;
        for (int i = 0; i < numbers.length; i++) {
            result ^=numbers[i];    // 1^2^3^2^1=3
        }
        return result;
    }
}
