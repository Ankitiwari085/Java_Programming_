package ComparableObjects;

import java.util.Arrays;

public class Student implements Comparable<Student>{

     public int rollNo;
     public float marks;

     public Student(int rollNo ,float marks){
         this.rollNo=rollNo;
         this.marks =marks;
     }
@Override
    public String toString(){
         return rollNo+ " :"+ marks;
    }

    @Override
    public int compareTo(Student  o) {
        int diff=(int)(this.marks- o.marks);
        return diff;
    }
}




class testStudent{

    public static void main(String[] args) {
        Student student1 =new Student(12,52.20f);
        Student student2 = new Student(14,93.32f);
        Student student3 =new Student(16,85.02f);
        Student student4 = new Student(18,45.23f);
        Student student5 = new Student(20,89.23f);

        Object [] list = {student1,student2,student3,student4,student5};
        System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));



//        System.out.println(student1.compareTo(student2));
//        System.out.println(student2.compareTo(student1));
    }
}
