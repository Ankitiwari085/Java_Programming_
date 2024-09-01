package Gaming_Question;
import java.util.Scanner;
public class Lottery {
    public static void main(String[] args) {
        int lotteryNumber = (int)(Math.random()*100);
//        System.out.println(lotteryNumber);
        Scanner input =new Scanner (System.in);
        System.out.println("Enter Your Lottery Number :- ");
        int guessNumber = input.nextInt();

        if(guessNumber == lotteryNumber)
            System.out.println("Exact Match : You Win $10,000 ");
        else if (guessNumber %10 == lotteryNumber/10 && guessNumber /10 == lotteryNumber%10) {
            System.out.println("Match All Digits : You win $ 3,000 .");
        } else if (guessNumber %10 == lotteryNumber/10 || guessNumber /10 == lotteryNumber%10 || guessNumber %10 == lotteryNumber%10 || guessNumber /10 == lotteryNumber/10 ) {
            System.out.println("Match ONE Digit : You Win $ 1,000 .");
        }
        else
            System.out.println("NO Match !! LOSS LOSS LOSS ");


    }
}
