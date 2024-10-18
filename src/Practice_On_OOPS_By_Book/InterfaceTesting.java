package Practice_On_OOPS_By_Book;

public class InterfaceTesting {
    public static void main(String[] args) {
        Car car1 =new Car();
        car1.drive();
        car1.speed();
        System.out.println(car1.NumberOfSeat());
        System.out.println(car1.automotation());

    }
}


 class Car implements Vehicles{

    @Override
    public void drive() {
        System.out.println("Driving is in the process ...");
    }

    @Override
    public void speed() {
        System.out.println("the Highest Speed Of the Car is 500 Km/h");
    }

    @Override
    public int NumberOfSeat() {
        return 4;
    }

    @Override
    public boolean automotation() {
        return false;
    }

    static {
        System.out.println("Staic Keyword is Called ");
    }
}
