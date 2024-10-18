package Exception_Handling;

import java.io.IOException;

public class Test2withFinallyKeyword {
    public static void main(String[] args) {

        try{
            CircleWithException c1 =new CircleWithException(5);
            CircleWithException c2 =new CircleWithException();
            CircleWithException c3 =new CircleWithException(-5);
            CircleWithException c4 =new CircleWithException(5);
            CircleWithException c5 =new CircleWithException();
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex);
        }
        finally {
            System.out.println(CircleWithException.getCount());
        }

    }

}

class CircleWithException{
    private double radius;
    private static int count=0;

    public CircleWithException(){
        radius =0;
        count++;
    }
    public CircleWithException(double newradius){
        setRadius(newradius);
        count++;
    }

    public void setRadius(double radius) {
        if(radius < 0){
             throw  new IllegalArgumentException("The radius should not be Negative ..");
        }
        else
            this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public static int getCount(){
        return count;
    }

}
