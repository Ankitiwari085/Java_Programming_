package Practice_Question;

import java.util.Scanner;

public class Finding_Even_Number_with_AND_Operator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number for Checking Even or Odd :");
        int n = scanner.nextInt();
        if (IsEven(n))
            System.out.println("The Given Number (" +n+ ") is Odd Number ");
        System.out.println("The Given Number (" +n+ ") is Even Number ");

    }
    public static boolean IsEven(int number){
        if((number & 1)== 1)
            return true;
        return false;
    }
}
