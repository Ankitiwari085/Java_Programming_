package Practice_Question;

public class FIndingTarget_in_InfiniteSortedArray {
    public static void main(String[] args) {
        int []arr = {1,2,3,4,5,6,7,8,9,11,13,14,16,18,19,20,23,25,27,28,29,33,37,38,39,46,47,49,51,53,56,58,62,64};
        System.out.println(findingAnswer(arr,51));
    }
    static int findingAnswer(int[]arr, int target){
        int start =0;
        int end=1;
        while(arr[end]< target){
            int newStart=end+1;
             end=end+(end-start+1)*2    ;
            start=newStart;
        }
        return  searchingTarget(arr,target,start,end);
    }
    static int searchingTarget(int []arr,int target, int start, int end){
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>target)
                end=mid-1;
            if (arr[mid]<target)
                start=mid+1;
            else
                return mid;
        }
        return -1;
    }
}
