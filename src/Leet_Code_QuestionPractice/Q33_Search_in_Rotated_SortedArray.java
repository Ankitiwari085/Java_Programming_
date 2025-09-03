package Leet_Code_QuestionPractice;

public class Q33_Search_in_Rotated_SortedArray {
    public static void main(String[] args) {

    }
    public static  int search(int[] nums, int target) {
        int peak= searchPeak(nums);
        int firstTry= searchTarget(nums,target,0,peak);
        if(firstTry != -1)
            return firstTry;
        return searchTarget(nums,target,peak+1,nums.length-1);
    }
    static int searchPeak(int [] arr){
        int start=0;
        int end= arr.length-1;
        while(start<=end){
            int mid = start+(end-start)/2;
            if(mid<end && arr[mid]> arr[mid+1])
                return mid;
            if( mid> start && arr[mid-1]> arr[mid])
                return mid-1;
            if (arr[start] >= arr[mid])
                end=mid-1;
            else
                start=mid+1;
        }
        return -1;
    }
    static int searchTarget(int []arr,int target, int start, int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid]<target)
                start=mid+1;
            if(arr[mid]>target)
                end=mid-1;

            if (arr[mid]==target){
                return mid;
            }
        }
        return -1;
    }
}
