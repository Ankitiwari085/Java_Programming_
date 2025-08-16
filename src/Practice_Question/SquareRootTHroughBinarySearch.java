package Practice_Question;

public class SquareRootTHroughBinarySearch {
    public static void main(String[] args) {
        int number =6;
        int precision =3;

        System.out.printf("%.3f",squareRoot(number,precision));
    }
    static double squareRoot(int number, int precesion){
        int start =0 ;
        int end = number;
        double root =0.0;

        while(start <=end){
            int mid=start+(end-start)/2;
            if (mid*mid == number) {
                return mid;
            }
            if (mid*mid >= number) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
       float increment= 0.1f;
        root =end;
        for (int i = 0; i < precesion; i++) {
            while(root*root < number){
                root+=increment;
            }
            root-=increment;
            increment/=10;
        }
        return  root;
    }
}
