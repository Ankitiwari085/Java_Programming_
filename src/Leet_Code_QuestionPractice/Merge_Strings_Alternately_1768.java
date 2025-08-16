package Leet_Code_QuestionPractice;
class Merge_Strings_Alternately_1768 {
    public String mergeAlternately(String word1, String word2) {
        String merged = "";
        int length_word1= word1.length()-1;
        int length_word2 = word2.length()-1;
        int i=0;
        int k=0;
        while (i <= length_word1 || k <= length_word2) {
            if (i <= length_word1) {
                merged += word1.charAt(i++);
            }
            if (k <= length_word2) {
                merged += word2.charAt(k++);
            }
        }
        return  merged;
    }
    public static  void main(String []arg){
        String merged= new Merge_Strings_Alternately_1768().mergeAlternately("ankit","tiwari");
        System.out.println(merged);
    }
}