package Leet_Code_QuestionPractice;

public class Q34_FindFirst_andLastPosition_ofElement_inSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int [] answer = new int[2];
        answer[0]=binarySearch(nums,target,true);//startIndex
        answer[1]=binarySearch(nums,target,false);// EndIndex

        return answer;
    }

    static int binarySearch(int []nums , int target ,boolean IsstartIndex){
        int ans =-1;
        int start = 0;
        int end= nums.length-1;
        while(start<= end){
            int mid = start+(end-start)/2;
            if (target < nums[mid]){
                end =mid-1;
            } else if (target > nums[mid]) {
                start=mid+1;
            }else {
                ans=mid;
                if (IsstartIndex){
                    end=mid-1;
                }else {
                    start = mid+1;
                }
            }
        }
        return ans;
    }
}
