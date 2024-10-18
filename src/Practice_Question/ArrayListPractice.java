package Practice_Question;

import java.util.ArrayList;

public class ArrayListPractice {
    public static void main(String[] args) {
        ArrayList <Integer> intList = new ArrayList<Integer>();



        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(1,0);

        System.out.println("The Size of the List is :  "+intList.size());
        System.out.println(intList);
        System.out.println(intList.remove(4));
        System.out.println("The Size of the List is :  "+intList.size());
        System.out.println(intList);
        intList.clear();
        System.out.println("The Size of the List is :  "+intList.size());
        System.out.println(intList);

    }
}
