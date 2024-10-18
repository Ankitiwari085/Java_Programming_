package ClonningObject;


import java.util.Arrays;

class Human implements Cloneable{
     int age;
     String name;
     int [] arr ;
     public Human(int age, String name){
          this.age=age;
          this.name= name;
          this.arr = new int[]{1, 2, 3, 4, 5};
     }

     public Human(Human other) {
         this.name = other.name;
         this.age = other.age;
         this.arr =other.arr;

     }
     public Object clone () throws  CloneNotSupportedException{
         Human twin =(Human) super.clone(); // shallow Clonning ..




         twin.arr= new int[twin.arr.length]; // Deep cloning
         for (int i = 0; i < twin.arr.length; i++) {
             twin.arr[i] = this.arr[i];

         }
         return twin;
     }

 }


public class Main {
    public static void main (String[] args)  throws  CloneNotSupportedException{
        Human A = new Human(21, "Ram");
       // Human Acopy =new Human(A);

        Human Acopy =(Human) A.clone();
        System.out.println(Acopy.age + " : "+Acopy.name);

        Acopy.arr[0] =100;
        System.out.println(Arrays.toString(A.arr));

        System.out.println(Arrays.toString(Acopy.arr));


        Acopy.name ="Ankit";
        System.out.println(A.name);
        System.out.println(Acopy.name);
    }
}
