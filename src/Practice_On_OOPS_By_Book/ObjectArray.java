package Practice_On_OOPS_By_Book;
import java.util.Random;
public class ObjectArray {
    public static void main(String[] args) {
        MyCircle []circle ;
         circle =createCircleArray();
        displayCircleArray(circle);
        System.out.println("The Total Sum of the Area Of All Circle :- "+sumArea(circle));
        System.out.println("\n\n");
        MyCircle.TotalcircleObject();

    }
    public static MyCircle[] createCircleArray(){
        Random random =new Random();
        MyCircle [] c =new MyCircle[10];
        for (int i = 0; i < c.length; i++) {
            c[i]=new MyCircle(random.nextDouble(1,100));
        }
        return c;
    }

    public static void displayCircleArray(MyCircle []c) {
        for (int i = 0; i < c.length; i++) {
            System.out.println("Radius :- " + c[i].getRadius() +"\t\tArea :- "+ c[i].getArea());


        }

    }
    public static double sumArea(MyCircle [] c){
        double sum=0;
        for (int i = 0; i < c.length; i++) {
            sum += c[i].getArea();
        }
        return sum;


    }
}


class  MyCircle{
    private double radius ;
    private static int circle_count=0;
    MyCircle(){
        radius =0;
        circle_count++;
    }
    MyCircle(double radius){
        this.radius=radius;
        circle_count++;
    }
    public  double getArea(){
        return  radius*radius*Math.PI;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    public double getRadius() {
        return radius;
    }
    public static  void TotalcircleObject(){
        System.out.println("The Total Number Of Circle Is :- " + circle_count);
    }
}