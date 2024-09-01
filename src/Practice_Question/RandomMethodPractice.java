package Practice_Question;

import java.util.Random;

public class RandomMethodPractice {
    public static void main(String[] args) {
//        Random random =new Random();
//
//        System.out.println(random.nextInt(100));
//        System.out.println(random.nextInt(10,20));
//        System.out.println(random.nextBoolean());



        Random random1 =new Random(3);   // Having the Same seed that is 3 means it is something that is connect
        Random random2 =new Random(3);   // with Millisecond which is its internal Mathematical Formula to give A sequential random Number.
        for (int i = 0; i < 10; i++) {
            System.out.print(random1.nextInt(0,100) + "  ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(random2.nextInt(0,100) + "  ");
        }


//
//        Random random1 =new Random(32);   // Having the Same seed that is 3 means it is something that is connect
//        Random random2 =new Random(335);   // with Millisecond which is its internal Mathematical Formula to give A sequential random Number.
//        for (int i = 0; i < 10; i++) {
//            System.out.print(random1.nextInt(0,100) + "  ");
//        }
//        System.out.println();
//        for (int i = 0; i < 10; i++) {
//            System.out.print(random2.nextInt(0,100) + "  ");
//        }

    }
}
