package Leet_Code_QuestionPractice;

public class Q26_RemovingDuplicateElements_SortedArray {
    public static void main(String[] args) {
//        int [] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int [] nums = {1, 1, 2};
        int k =removeDuplicates(nums);

    }
    public static  int removeDuplicates(int[] nums) {
        int i=0;
        int j=1;
        int []newarr= new int [nums.length];
        newarr[0]=nums[0];
        while(i<nums.length-1){
            if(  i<nums.length-1&& nums[i]==nums[i+1]){
                i++;
            }else{
                newarr[j]=nums[i+1];
                i++;
                j++;
            }
        }
       // nums=newarr;
        for (int l = 0; l < j; l++) {
            System.out.print(newarr[l]);
        }
        return j;
    }
}
