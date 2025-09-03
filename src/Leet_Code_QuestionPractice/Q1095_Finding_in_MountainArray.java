package Leet_Code_QuestionPractice;

public class Q1095_Finding_in_MountainArray {
    public static void main(String[] args) {
         int []arr={0,5,3,1};
        System.out.println(search(arr,1));
    }
    public static int search(int []arr,int target){
        int peak =peakIndex(arr);
        int firstTry=searchingTarget(arr,target,0,peak);
        if (firstTry != -1){
            return firstTry;
        }
        return searchingTargetSecondtry(arr,target,peak+1,arr.length-1);
    }
    public static int peakIndex(int[] arr) {
        int start =0;
        int end=arr.length-1;
        while(start<end){
            int mid =start+(end-start)/2;
            if(arr[mid]>arr[mid+1])
                end=mid;
            if (arr[mid]<arr[mid+1])
                start=mid+1;
        }
        return start;
    }
    static int searchingTarget(int []arr,int target, int start, int end){
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
    static int searchingTargetSecondtry(int []arr,int target, int start, int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid]>target)
                start=mid+1;
            if(arr[mid]<target)
                end=mid-1;

            if (arr[mid]==target){
                return mid;
            }
        }
        return -1;
    }
}
