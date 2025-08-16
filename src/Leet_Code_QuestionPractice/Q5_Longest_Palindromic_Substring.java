package Leet_Code_QuestionPractice;

public class Q5_Longest_Palindromic_Substring {

    public static void main(String[] args) {
        String string ="fgracecarsd";
        System.out.println(longestPalindrome(string));
    }


    public  static String longestPalindrome(String s) {
        String longest_palindromic_string= "";
        for (int i =0;i<s.length();i++){
            int left =i;
            int right =i;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                String substring = s.substring(left,right+1);
                if (substring.length()>longest_palindromic_string.length()){
                    longest_palindromic_string=substring;
                }
                left-=1;
                right+=1;
            }
            left =i;
            right =i+1;
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                String substring = s.substring(left,right+1);
                if (substring.length()>longest_palindromic_string.length()){
                    longest_palindromic_string=substring;
                }
                left-=1;
                right+=1;
            }
        }

        return longest_palindromic_string;
    }
}

