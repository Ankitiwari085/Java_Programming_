package Leet_Code_QuestionPractice;

public class Q14_LongestCommonPrefix {
    public static void main(String[] args) {
        String []strs = {"flower","flow","flight"};
        System.out.println(commonPrefix(strs));
    }

    public static String commonPrefix(String [] strs){
        String prefix=strs[0];
        for (int i = 1; i < strs.length; i++) {
            while(!strs[i].startsWith(prefix)){
                prefix=prefix.substring(0, prefix.length()-1);
                if (prefix==""){
                    return "";
                }
            }
        }
        return prefix;
    }
}
