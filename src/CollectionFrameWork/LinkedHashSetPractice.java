package CollectionFrameWork;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetPractice {
    public static void main(String[] args) {
        Set <String> set1 = new LinkedHashSet<String>();
        set1.add("Ram");
        set1.add("Shyam");
        set1.add("Sushil");
        set1.add("Krishna");

        System.out.println(set1);

        for (Object element: set1)
            System.out.print(element+ "  ,  ");

        // Methods Are same as the HashSet Method
        // only difference is in the storing the element in the different way in hashset and Linked HashSet  ..
    }
}
