package Practice_On_OOPS_By_Book;

import java.sql.SQLOutput;

public class inheritancePractice {
    public static void main(String[] args) {
        Animal elephant =new Elephant(2,2,4,1);
            elephant.sleep();

    }

     static {
         System.out.println("Static is Executed !!");
    }
}

class Animal{
    int eye;
    int ear;
    int leg;
    public Animal(){
        System.out.println("Animal class , Constructor without Argument");
    }
    public Animal(int eye,int ear,int leg){
        this.ear=ear;
        this.eye=eye;
        this.leg=leg;
        System.out.println("Animal class , Constructor with Argument");
    }

    public void eat(){
        System.out.println("Animal:- Eat Method ");
    }


    public void sleep(){
        System.out.println("Animal:- sleep Method ");
    }


    public void walk(){
        System.out.println("Animal:- walk Method ");
    }
}



class Elephant extends Animal{
    int trunk ;
    public Elephant(){

        System.out.println("Elephant class , Constructor without Argument");
    }

    public Elephant(int eye,int ear, int leg ,int trunk){
//        this();
        super(eye,ear,leg);
        this.trunk=trunk;
        System.out.println("Elephant class , Constructor with Argument");
    }

    public void elephantMethod(){
        System.out.println("IN the Elephant Method ....");
    }
    public void sleep(){
        super.sleep() ;
        System.out.println(  "Elephant:- sleep Method ");
    }

}
