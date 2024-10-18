package CollectionFrameWork;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetPractice {
    public static void main(String[] args) {

        Set<String> set1 = new LinkedHashSet<String>();
        set1.add("Ram");
        set1.add("Shyam");
        set1.add("Sushil");
        set1.add("Krishna");
        set1.add("Ankit Tiwari");

        System.out.println(set1);


        // Tree set store the element according the Accesending or descending  Order in comparesion to other set ...


        Set <String> treeSet = new TreeSet<String>(set1);
        System.out.println(treeSet);
    }
}
