package CollectionFrameWork;

import java.util.HashSet;
import java.util.Set;

public class HashSetPractice {
    public static void main(String[] args) {
        Set <String>set1 =new HashSet<String>();
        set1.add("Ankit Tiwari");
        set1.add("Amit Tiwari");
        set1.add("Sindhu Tiwari");
        set1.add("Ankit");
//        set1.add("Ankit Tiwari");   // Duplicate element is not considered inn the set ..

        System.out.println(set1);        // hashset will contain the element in a regular order as the way by which the
                                        // element is added .   For adding the eleement in the ordered way as they added we use
                                                        //  HashLinkedSet ....


//        for(String element :set1)              // Iterator Method  by using For Each loop ..
//            System.out.print(element +" , ");




        Set <String> set2 = new HashSet<String>();
        set2.add("Umesh Tiwari");
        set2.add("Rambabu Tiwari");
        set2.add("Ram Tiwari");
        set2.add("Sindhu Tiwari");

        System.out.println(set2);


        System.out.println(set1.size());
        System.out.println(set2.size());


//        set1.addAll(set2);
//        System.out.println(set1);
//        System.out.println(set1.size());

//        set1.retainAll(set2);       // Common Element between the two set ..
//        System.out.println(set1);
//        System.out.println(set1.size());


        set1.remove("Ankit");
        System.out.println(set1);
        System.out.println(set1.size());

        set2.removeAll(set2);
        System.out.println(set2);
        System.out.println(set2.size());


    }

}
