package Practice_Question;

public class SumOfRow_PascalTriangle {
    public static void main(String[] args) {
        int row= 5;
        int sum = 1 << (row-1); // 2^n-1 = 1 << (n-1)

        System.out.println(sum);
    }
}
