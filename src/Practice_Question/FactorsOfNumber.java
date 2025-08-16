package Practice_Question;

import java.util.ArrayList;

public class FactorsOfNumber {
    public static void main(String[] args) {
        int number = 36;
        factor(number);

    }
    static void factor(int number ){
        ArrayList<Integer> list= new ArrayList<>();
        for(int i =1; i<=Math.sqrt(number);i++){
            if (number%i == 0){
                if (number / i == i)
                    System.out.print(i+" ");
                else {
                    System.out.print(i + " ");
                    list.add(number/i);
                }
            }
        }
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.print(list.get(i)+" ");
        }
    }
}



