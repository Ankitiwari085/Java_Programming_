package Practice_Question;

public class EuclidianAlgorithm_HCF_LCM {
    public static void main(String[] args) {
        int num1= 20;
        int num2= 88;
        System.out.println(hcf(num1,num2));
        System.out.println(lcm(num1,num2));
    }
    static int hcf(int num1 ,int num2){
        if (num1 == 0)
            return num2;
        return hcf(num2%num1 , num1);
    }
    static int lcm(int num1, int num2){
        return (num1*num2)/ hcf(num1, num2);
    }
}
