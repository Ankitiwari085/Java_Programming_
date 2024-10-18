package CollectionFrameWork;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Random;

public class LinkedList_Practice {
    public static void main(String[] args) {
        Random random = new Random();
        LinkedList<Integer> list=new LinkedList();

        for (int i = 1; i <=10; i++) {
            list.add(random.nextInt(1,101) );
        }
        System.out.print("The List  :- ");
        System.out.println(list);
//        System.out.println( "The Size of the Linked List: "+ list.size());
//        System.out.println("Remove First  "+list.removeFirst());
//        System.out.println("Remove Last "+ list.removeLast());
//        System.out.println("The List after removing the First and Last " +  list);
//        System.out.println( "The Size of the Linked List: "+ list.size());
//        list.sort(Comparator.reverseOrder());
//        System.out.println(" The List in the Descending Order :  " +list);
//        list.sort(Comparator.naturalOrder());
//        System.out.println("The List in the Aescending Order : "+ list);
//

//        System.out.println(list.hashCode());

//        System.out.println(list.element());


    }
}
