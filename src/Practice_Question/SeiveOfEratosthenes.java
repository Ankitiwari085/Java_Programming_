package Practice_Question;

public class SeiveOfEratosthenes {
    public static void main(String[] args) {
        int num1= 40;
        boolean [] primes = new boolean[num1+1];
        seive(num1,primes);
    }
    public static void seive(int num1,  boolean[] primes){

        for (int i = 2; i*i <= num1; i++) {
            if (!primes[i]){
                for (int j = i*2; j <= num1 ; j+=i) {
                    primes[j]=true;
                }
            }
        }

        for (int i = 2; i <= num1; i++) {
            if (!primes[i])
                System.out.print(i+" ");
        }
    }
}
