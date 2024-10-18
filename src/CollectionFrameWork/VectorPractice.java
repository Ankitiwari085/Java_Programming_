package CollectionFrameWork;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Vector;
import java.util.Scanner;

public class VectorPractice {
    public static void main(String[] args) {
        Vector  list =new Vector();
//        list.add("Ankit");
//        list.add("Amit");
//        list.add("Umesh");

        Scanner input = new Scanner (System.in);
        for(int i =0;i<5;i++){
            System.out.println("Enter the  Element of the List : ");
            list.add(input.next());
        }
        System.out.println(list);
    }
}
