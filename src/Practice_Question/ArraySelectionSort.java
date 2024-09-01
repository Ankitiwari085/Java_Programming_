package Practice_Question;
import java.util.Scanner;

public class ArraySelectionSort {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
    Scanner input =new Scanner (System.in);
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Enter the  Element of the Array  :- ");
            arr1[i]=input.nextInt();
        }
        System.out.println("The Given Array :- ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
        for (int i = arr1.length-1; i >0 ; i--) {
            int maxIndex = getMaxIndex(arr1, i);
              swap(arr1,maxIndex, i);
        }
        System.out.println(" ");
        System.out.println("The Sorted Array :- ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+" ");
        }
    }

    public static int getMaxIndex(int[] arr1, int length) {
        int maximum = arr1[0];
        int maximumIndex=0;
        for (int i = 0; i <=length; i++) {
            if (maximum < arr1[i]) {
                maximum = arr1[i];
                maximumIndex = i;
            }
        }
        return maximumIndex;
    }

    public static void swap(int [] arr,int max,int position){
        int temp=arr[max];
        arr[max] =arr[position];
        arr[position]= temp;
    }
}
