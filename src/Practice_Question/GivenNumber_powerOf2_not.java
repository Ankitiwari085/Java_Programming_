package Practice_Question;

import java.util.Scanner;

public class GivenNumber_powerOf2_not {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the Number : ");
        int number =scanner.nextInt();

        if ((number & (number-1)) == 0){
            System.out.println("The Given Number is the Power Of 2");
        }
        else
            System.out.println("The Given Number is NOT the Power Of 2");

    }
}
