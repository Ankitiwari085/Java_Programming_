package Practice_Question;

import java.util.Scanner;

public class Finding_aPOwer_b {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the Base :");
        int base = scanner.nextInt();
        System.out.print("Enter the Power :");
        int power = scanner.nextInt();

        int answer =1;

        while(power >0){
            if ((power & 1)==1){
                answer*=base;
            }
            base *=base;
            power=power>>1;
        }
        System.out.println(answer);
    }
}
