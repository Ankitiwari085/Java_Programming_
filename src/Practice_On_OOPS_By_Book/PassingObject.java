package Practice_On_OOPS_By_Book;

public class PassingObject {

    public static void main(String[] args) {
        Circle circle1 =new Circle();
        Circle circle2 =new Circle(2.0);

        get_details(circle2);
        get_details(circle1);
        circle1.setRadius(3.0);
        get_details(circle1);
        Circle.circleObject();
    }

    public static void get_details(Circle c){
        System.out.println(" Radius :- "+c.getRadius()+ "\t\t  Area :- "+c.getArea());
    }

}

class  Circle{
    private double radius ;
    private static int circle_count=0;
    Circle(){
        radius =0;
        circle_count++;
    }
    Circle(double radius){
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
    public static  void circleObject(){
        System.out.println("The Total Number Of Circle Is :- " + circle_count);
    }
}
