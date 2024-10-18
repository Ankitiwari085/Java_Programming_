package Practice_On_OOPS_By_Book;

public class AbstractClassPractice  {

    public static void main(String[] args) {
        Abstract_A obj1= new Abstract_B(5,3);
        obj1.display();
        System.out.println( "Sum :- " +obj1.sum());
        System.out.println("Difference :-  " +obj1.difference());
        System.out.println("Multiply :- " +obj1.multiply());

    }
}

 abstract class Abstract_A{
    int x;
    int y;
   Abstract_A(int x,int y){
       this.x=x;
       this.y=y;
   }
    void display(){System.out.println("Valur Are   :- ("+x +","+ y+")");}
    abstract  int sum();
    abstract int difference ();
    abstract int multiply();
}

 class Abstract_B extends Abstract_A{
    int answer;

    Abstract_B(int x,int y){
        super(x,y);


    }
     int sum(){
         return x+y;
     };
      int difference (){
          return x-y;
      };
      int multiply(){
          return x*y;
      };

 }