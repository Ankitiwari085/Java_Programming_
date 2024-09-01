package Practice_Question;

public class ArrayCopyMethod {
    public static void main(String[] args) {
        int [] arr1 ={1,2,3,4,5,6,7,8,9};
        int arr2[] ={11,12,13,14,15,16,17,18,19,0,0};
        System.out.println(arr1);
        System.out.println(arr2);
       for(int i=0;i< arr1.length;i++){
           System.out.print(arr1[i]+" , ");
       }
        System.out.println();
        for(int i=0;i< arr1.length;i++){
            System.out.print(arr2[i]+" , ");
        }
        System.out.println();
        System.arraycopy(arr1,0,arr2,0,arr1.length);
//      System.arraycopy(arr1,0,arr2,1,5);
//        arr2=arr1;

        for(int i=0;i< arr1.length;i++){
            System.out.print(arr1[i]+" , ");
        }
        System.out.println();
        for(int i=0;i< arr1.length;i++){
            System.out.print(arr2[i]+" , ");
        }
        System.out.println();
        System.out.println(arr1);
        System.out.println(arr2);

    }
}
