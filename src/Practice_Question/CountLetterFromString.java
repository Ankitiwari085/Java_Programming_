package Practice_Question;
import java.util.Scanner;

public class CountLetterFromString {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.println("Enter the String :- ");
        String string =input.nextLine();
        int [] count =countletter(string.toLowerCase());

        display(count);
    }
    public static int [] countletter( String string){
        int[] counts=new int [26];
        for (int i=0;i<string.length();i++){
            counts[string.charAt(i)-'a']++;
        }
        return counts;
    }

    public static void display(int [] count){
        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0){
                System.out.println("              "+(char)(i+'a') + " Occurs "+ count[i] +"times");
            }
        }
    }
}
