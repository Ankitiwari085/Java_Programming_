package Practice_Question;

import javax.swing.*;
import java.util.Arrays;

public class SearchingIn_SortedMatrices {
    public static void main(String[] args) {
        int [][]arr= {
                {10, 13, 14},
                {15, 16, 18},
                {19, 20, 23},
        };
        System.out.println(Arrays.toString(search(arr, 20)));
    }
    static int [] search(int [][] arr,int target){
        int row=0;
        int column=arr.length-1;
        while(row < arr.length && column >= 0 ){
            if (arr[row][column] == target){
                return new int[]{row,column};
            } else if (arr[row][column]>target){
                column--;
            }
            else{
                row++;
            }

        }
        return  new int []{-1,-1};
    }
}
