package Practice_Question;

public class Ceiling_FlooringOfNumber {
    public static void main(String[] args) {
        int []arr={1,5,8,10,13,26,38};
        int target = 37;
        System.out.println(ceilingNumber(arr,target));
        System.out.println(floorNumber(arr,target));


    }
    static int ceilingNumber(int [] arr ,int target){
        int start =0;
        int end = arr.length-1;

        while(start<=end){
            int mid =start+(end-start)/2;
            if(arr[mid]== target){
                return arr[mid];
            }
            if (arr[mid] > target){
                end= mid-1;
            } else if (arr[mid]<target) {
                start =mid+1;

            }
        }
        return arr[start];
    }

    static int floorNumber(int [] arr ,int target){
        int start =0;
        int end = arr.length-1;
        while(start<=end){
            int mid =start+(end-start)/2;
            if(arr[mid]== target){
                return arr[mid];
            }
            if (arr[mid] > target){
                end= mid-1;
            } else if (arr[mid]<target) {
                start =mid+1;

            }
        }
        return arr[end];
    }
}
