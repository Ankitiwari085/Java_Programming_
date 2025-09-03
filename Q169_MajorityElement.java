public class Q169_MajorityElement {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        int counter =0;
        int majority=nums[0];
        for(int num:nums){
            if(majority == num){
                counter++;
            }
            else
                counter--;
            if (majority != num && counter==0){
                majority=num;
                counter++;
            }

        }
        return majority;
    }

}
