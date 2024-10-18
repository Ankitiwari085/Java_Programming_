package Exception_Handling;



  public class creatingExceptionClass  extends Exception{
    private double radius ;
    public creatingExceptionClass(double radius){
        super("Invalid Radius"+ radius);
        this.radius=radius;

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double newRadius) throws creatingExceptionClass{
        if(newRadius<0){
            throw  new creatingExceptionClass(newRadius);

        }
        else
            this.radius=newRadius;
    }
}

