package Practice_On_OOPS_By_Book;

public class ObjectCasting {
    public static void main(String[] args) {
        A1 obj1 =new A1();
        B obj2 =new B();

        obj1.show();
        obj2.show1();

        A1 obj3 =new B();
          B obj4 =(B)obj3;

        obj4.show1();

        B obj5 = (B) new A1();  //upcasting  amd downCasting  in object concept...

        obj5.show();
        obj5.show1();

    }
}

class A1{
    void show(){
        System.out.println("In A Show");
    }
}
class B extends  A1{
    void show1(){
        System.out.println("In B Show ");
    }

}