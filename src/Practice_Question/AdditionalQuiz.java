package Practice_Question;

import java.util.Scanner;

public class AdditionalQuiz {
    public static void main(String[] args) {
        int number1=(int)System.currentTimeMillis()*6%10;
        int number2 =(int)System.currentTimeMillis()*9%10;

        Scanner input =new Scanner(System.in);

        System.out.println("Enter the sum of "+ number1 +" and "+ number2+" :- ");
        int answer= input.nextInt();
        System.out.println("The Sum  of "+ number1 +" and "+ number2+" = "+answer+" is "+ (number1+number2==answer));
    }
}
