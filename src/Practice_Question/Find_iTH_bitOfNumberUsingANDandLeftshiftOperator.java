package Practice_Question;

import java.util.Scanner;

public class Find_iTH_bitOfNumberUsingANDandLeftshiftOperator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number  = scanner.nextInt();
        System.out.print("Enter the place of ith position :");
        int place = scanner.nextInt();
        System.out.println("The Bit present in the given position  of the given number "+ Solution(number,place));
    }
    public static int Solution(int number , int place){
        return( number & (1<<(place-1)))!= 0?1:0;
    }
}
