package Recursion;

import java.util.Scanner;

public class IsPalindrome {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        System.out.print("Enter the String : ");
        String s =input.next();
        System.out.println(" The Given String is Palindrome  OR Not : "+palindrome(s));

    }
    public static boolean palindrome (String s){
        if (s.length() <= 1)
            return  true;
       else if(s.charAt(0) != s.charAt(s.length()-1))
              return false;
         else
             return palindrome (s.substring(1,s.length()-1));
    }

}
