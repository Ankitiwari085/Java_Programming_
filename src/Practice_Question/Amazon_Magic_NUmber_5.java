package Practice_Question;

public class Amazon_Magic_NUmber_5 {
    public static void main(String[] args) {
        int base =5;
        int n =5;

        int answer =0;
         while(n>0){
             int lastDigit = n &1 ;
             n=n>>1;
             answer+= lastDigit* base;
             base*=5;
         }
         System.out.println(answer);
    }
}
