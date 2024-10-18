package Practice_Question;
import java.util.Scanner;
public class IspalindromeOrNot {
    public static void main(String[] args) {
        String word ;
        Scanner input =new Scanner (System.in);
        System.out.println("Enter the Word For Checking It is Palindrome Or NOt :- ");
        word = input.nextLine();

        if(ispalindrome(word.toLowerCase()))
            System.out.println("The Word  '"+ word +"' is Palindrome");
        else
            System.out.println("The Word '"+ word +"'  is Not a Palindrome");



    }
    public static boolean ispalindrome(String word){
        int start =0;
        int end =word.length()-1;
        while(start <= end){
            if(word.charAt(start)!=word.charAt(end))
                return false;
            start++;
            end --;
        }
        return true;

    }
}
