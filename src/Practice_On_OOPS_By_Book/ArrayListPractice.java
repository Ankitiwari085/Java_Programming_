package Practice_On_OOPS_By_Book;
import  java.util.ArrayList;

public class ArrayListPractice {
    public static void main(String[] args) {
        ArrayList arrayList =new ArrayList();
        for (int i = 1; i <=10; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
        System.out.println("Lenght :- "+ arrayList.size());
        System.out.println("Is Empty :- "+ arrayList.isEmpty());
        arrayList.add(10,11);
        System.out.println(arrayList);

    }
}
