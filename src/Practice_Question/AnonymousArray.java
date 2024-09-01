package Practice_Question;

public class AnonymousArray {
    public static void main(String[] args) {
        printArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});


    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " , ");
        }
    }
}
