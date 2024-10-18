package Practice_Question;

public class GenericsMethodPractice {

    public static void main(String[] args) {
        Integer [] intger ={1,2,3,4,5};
        String [] string ={"A","B","C","D","E"};
        GenericsMethodPractice.<Integer>print(intger);
        GenericsMethodPractice.<String>print(string);
    }

     public static <Object> void print(Object[] o ){
         for (int i = 0; i < o.length; i++) {
             System.out.print(o[i]+"  ");
         }
         System.out.println();
     }
}
