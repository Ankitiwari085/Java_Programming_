package Leet_Code_QuestionPractice;

public class Q852_PeakIndex_inMountainArray {
    public static void main(String[] args) {

    }
    public static int peakIndexInMountainArray(int[] arr) {
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
}
