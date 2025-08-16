package Practice_Question;

public class FindingXOR_Of_Number {
    public static void main(String args []){
//        int num1= 10;
//        System.out.println(XOR(num1));

        // Finding the XOR between Number = XOR(b) ^ XOR(a-1);

        int num1 =3;
        int num2=9;
        int answer =XOR(num2)^XOR(num1-1);

        System.out.println(answer);

    }

    public static int XOR(int num){
        if (num % 4 == 0)
            return num;
        if (num % 4 == 1)
            return 1;

        if (num % 4 == 2)
            return num+1;

        return 0;
    }
}
