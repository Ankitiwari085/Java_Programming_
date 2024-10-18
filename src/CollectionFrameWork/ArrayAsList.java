package CollectionFrameWork;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayAsList {
    public static void main(String[] args) {
        List<String> list1 = Arrays.asList(" Umesh","Ankit","Ram","Shyam");

        Collections.sort(list1);
        System.out.println(list1);
        Collections.sort(list1,Collections.reverseOrder());
        System.out.println(list1);

    }
}
