package TimeComplexcityCheck;
import java.util.Scanner;
public class ForLinearSearch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int []arr = new int  [100];
        for (int i =0 ;i < arr.length;i++){
//            System.out.println("Ente the Number : ");
//            arr[i]= input.nextInt();
            arr[i] =i;
        }
        System.out.println("Enter the Number To be Searched");
        boolean flag =false;
        int target = input.nextInt();
        long start= System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]== target) {
                System.out.println("The Element is found at index number " + i);
                flag =true;
                break;
            }

        }
        if (!flag)
            System.out.println("The Element is not Found");


        long end =System.currentTimeMillis();

        System.out.println("Time Taken to Search the Element in the List is "+ (end -start));
    }
}
