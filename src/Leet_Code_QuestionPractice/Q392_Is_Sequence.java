package Leet_Code_QuestionPractice;

public class Q392_Is_Sequence {
    public static void main(String[] args) {
        String str="ANkit";
        System.out.println(str.length()  +" "+str.charAt(5));

    }
    public static boolean isSubsequence(String s, String t) {
        int si=0;
        int ti=0;
        while(si<s.length() && ti < t.length()){
            if(s.charAt(si) == s.charAt(ti)){
                si++;
            }
            ti++;
            if(si == s.length()){
                return true;
            }
        }
        return false;
    }
}
