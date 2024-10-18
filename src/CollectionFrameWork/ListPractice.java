package CollectionFrameWork;

import java.util.*;

public class ListPractice {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();

        list1.add("Ram Kumar");
        list1.add("Shyam Kumar");
        list1.add("Sita Kumari");
        System.out.println(list1);
        System.out.println(" The Size of the List is "+list1.size());


        List <String> linkedList = new LinkedList<String>(list1);
//        System.out.println(linkedList.isEmpty());
//        System.out.println(linkedList);

//        linkedList.sort(Comparator.naturalOrder());
//        System.out.println(linkedList);

//        linkedList.sort(Comparator.reverseOrder());
//        System.out.println(linkedList);
        ListIterator <String> listIterator = linkedList.listIterator();

        listIterator =linkedList.listIterator(linkedList.size());
        while (listIterator.hasPrevious()){
            System.out.print(listIterator.previous()+ " ");


        }

    }
}
