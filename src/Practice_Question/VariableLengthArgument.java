package Practice_Question;

public class VariableLengthArgument {
    public static void main(String[] args) {
        printMax(12,14,56,34,57,23,57,24);
        printMax( new int[] {14,56,34,57,23,57,56,97});

    }
    public static  void   printMax( int ... numbers) {
     int result =-1;
        if (numbers [0]== 0) {
            System.out.println("No Argument Is passed ");
        } else {
            for (int i = 0; i < numbers.length; i++) {
                if (result < numbers[i])
                    result = numbers[i];

            }
        }
        System.out.println("The Maximum Number Is :- "+ result);
        return ;
    }
}
