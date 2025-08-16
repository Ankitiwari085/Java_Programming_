package Practice_Question;

public class NewtonRaphsonMethodForSquareRoot {
    public static void main(String[] args) {
        int number = 40;
        System.out.println(squareRoot(number));
    }


    static double squareRoot(int number ){
        double x =number;
        double root=0.0;
        while(true){
            root=0.5*(x+(number/x));
            if (Math.abs(root-x) < 0.5){
                break;
            }
            x=root;
        }
        return root;
    }
}
