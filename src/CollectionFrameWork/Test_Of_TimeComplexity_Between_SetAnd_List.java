package CollectionFrameWork;

import java.util.*;

public class Test_Of_TimeComplexity_Between_SetAnd_List {
    public static void main(String[] args) {
        Collection<Integer> set1 = new HashSet<Integer>();

        System.out.println("The Time Complexity of HashSet (in millisecond ) : "+ getTime(set1,500000));

        Collection<Integer> set2 = new LinkedHashSet<>();
        System.out.println("The Time Complexity of LinkedHashSet (in millisecond ) : "+ getTime(set2,500000));

        Collection<Integer> set3 = new TreeSet<Integer>();
        System.out.println("The Time Complexity of TreeSet (in millisecond ) : "+ getTime(set3,500000));

        Collection <Integer> list1 = new ArrayList<Integer>();
        System.out.println("The Time Complexity of ArrayList (in millisecond ) : "+ getTime(list1,500000));

        Collection<Integer> list2 = new LinkedList<Integer>();
        System.out.println("The Time Complexity of LinkedList  (in millisecond ) : "+ getTime(list2,500000));
    }

     public static long getTime(Collection <Integer> c , long size){
        long startTime = System.currentTimeMillis();

        List<Integer> list = new ArrayList<Integer>();
         for (int i = 0; i < size; i++) {
             list.add(i);
         }

         Collections.shuffle(list);

         for (int element : list){
             c.add(element);

         }

         Collections.shuffle(list);


         for (int element : list){
             c.remove(element);
         }

        long endTTime =System.currentTimeMillis();


        return  endTTime-startTime;
    }
}
