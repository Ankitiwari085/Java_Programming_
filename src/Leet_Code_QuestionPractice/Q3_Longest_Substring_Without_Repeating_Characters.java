package Leet_Code_QuestionPractice;

public class Q3_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
       // System.out.println( Q3Solution.lengthOfLongestSubstring("abcabcab"));
        //System.out.println( Q3Solution.lengthOfLongestSubstring("ababab"));
        System.out.println( Q3Solution.lengthOfLongestSubstring("pwwkew"));
    }
}
class Q3Solution {
    public static int lengthOfLongestSubstring(String s) {
        String subString="";

        int i=0;
        int lengthOfString=0;
        while (i<s.length()){
            char currentChar =s.charAt(i);
            if(subString.indexOf(currentChar)==-1){
                subString+=currentChar;
            }
            else {
                lengthOfString = lengthOfLongestSubstring(s.substring(1,s.length()));
                break;
            }
            i++;
        }

        return subString.length()>lengthOfString?subString.length():lengthOfString;

    }
}
