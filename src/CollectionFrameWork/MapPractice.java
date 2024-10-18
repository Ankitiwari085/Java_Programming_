package CollectionFrameWork;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;

public class MapPractice {
    public static void main(String[] args) {
        Map <String, Integer> hashMap =new HashMap<String,Integer>();
//        hashMap.put("Ankit",11);
//        hashMap.put("Amit",22);
//        hashMap.put("Prince",33);
//        hashMap.put("Umesh",44);


        Scanner input = new Scanner (System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter The Key And the value : ");
            hashMap.put(input.next(),input.nextInt());

        }

        System.out.println("The HashMap is Given Below : ");
        System.out.println(hashMap);
//        System.out.println(hashMap.get("Umesh"));


        Map <String, Integer> linkedHashMap = new LinkedHashMap<String,Integer>(hashMap);
        System.out.println("The Linked Hash Map is Display below : ");
        System.out.println(linkedHashMap);
        System.out.println(linkedHashMap.size());

            // When we use treeMap then the object is inserted in  the Acending Order ...

        Map <String,Integer> treeMap = new TreeMap<String,Integer>(hashMap);

        System.out.println("The Tree Map is given Below ;  ");
        System.out.println(treeMap);
        System.out.println(treeMap.put("Rahul",55));
        System.out.println("The Tree Map is Display after adding the new Object in the Map : ");
        System.out.println(treeMap);
    }
}
