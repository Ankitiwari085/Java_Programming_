package Practice_Question;
import java.util.Arrays;
public class ArrayMethodPractice {
    public static void main(String[] args) {
        int [] list1 = {1,3,5,6,8,9,10,2};
        int [] list2 ={12,23,34,21,42,24,11};

        int [] list =new int[list1.length+ list2.length];
            System.arraycopy(list1,0,list,0,list1.length);
        System.arraycopy(list2,0,list,list1.length,list2.length);
        System.out.println();
        for (int i = 0; i < list.length; i++) {
         System.out.print(list[i] + " ");
        }
        Arrays.sort(list1);
//        for (int i = 0; i < list1.length; i++) {
//            System.out.print(list1[i] + " ");
//        }
//        System.out.println();
//
//        System.out.println(Arrays.equals(list1,list2));
//
//        Arrays.fill(list2,0);
//        for (int i = 0; i < list2.length; i++) {
//            System.out.print(list2[i] + " ");
//        }
//        System.out.println();
//        Arrays.fill(list1,1,4,77);
//        for (int i = 0; i < list1.length; i++) {
//            System.out.print(list1[i] + " ");
//        }
    }

}
