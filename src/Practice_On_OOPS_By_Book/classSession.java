package Practice_On_OOPS_By_Book;

import java.sql.SQLOutput;

public class classSession {

    public static void main(String[] args) {
//     Student student1 =new Student();
//        System.out.println(student1.name);
//        System.out.println(student1.student_Id);
//        System.out.println(student1.is_Passed);
//        System.out.println(student1.cgpa);

     Student student2 =new Student("Ankit Tiwari",2015,8.1f);
     Student student3 =new Student("Amit Tiwari",2016,8.2f);
     Student student4 =new Student("Umesh Tiwari",2017,8.3f);
     Student student5 =new Student("Prince Tiwari",2018,8.4f);
        student2.student_Details();
        student3.student_Details();
        student4.student_Details();
        student5.student_Details();

        student2.attendance();
        student3.attendance();
        student4.attendance();
        student5.attendance();

        Student.total_Student();
    }
}


class  Student {
    String name ;
    int student_Id;
    boolean is_Passed;
    float cgpa;
     static int student_count =0;
    Student(){
        student_count ++;
    }
    Student (String Name,int Id,float cgpa){
        this.name=Name;
        this.student_Id =Id;
        this.is_Passed =true;
        this.cgpa =cgpa;
        student_count ++;
    }

    void attendance (){
        System.out.println(name + "  Present In The Class");
    }

   void student_Details(){    // String name,int id,boolean passed,float cgpa
       System.out.println("***************************");
       System.out.println("      Student Details   ");
       System.out.println(name);
       System.out.println(student_Id);
       System.out.println(is_Passed);
       System.out.println(cgpa);
       System.out.println("***************************");

   }
    static  void total_Student(){
        System.out.println("Total NUmber of Student :- " + student_count);
    }

}