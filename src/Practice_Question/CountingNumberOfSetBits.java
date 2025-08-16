package Practice_Question;

public class CountingNumberOfSetBits {
    public static void main (String args[]){
        int number =100;

        System .out.println(Integer.toBinaryString(number));

        int count=0;

        while(number > 0){
             count++;
             number = number & number-1;

        }
        System.out.println("The Number of Set Bits in a Given NUmber :"+ count);
    }
}
