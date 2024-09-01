package Practice_Question;

public class CountLettersInArray {
    public static void main(String[] args) {
        char [] chars =createArray();

        System.out.println("The Lower case Letter Are  Given Below :- ");
        displaychars(chars);
        int [] counts = countletter(chars);

        System.out.println("The Lower case Letter with their number of repetation are given below :- ");
        displayCounts(counts);
    }

    public static char[] createArray(){
        char [] chars =new char[100];
        for (int i=0;i<chars.length;i++){
            chars[i]=(char) ('a'+Math.random() * ('z'-'a'+1));
        }
        return chars;
    }
    public static void displaychars(char [] chars){
        for (int i =0;i<chars.length;i++){
            if((i+1)%10==0){
                System.out.println( chars[i]+  " ");
            }
            else
                System.out.print(chars[i]+" ");
        }

    }
    public static int [] countletter( char[] chars){
        int[] counts=new int [26];
        for (int i=0;i<chars.length;i++){
           counts[chars[i]-'a']++;
        }
        return counts;
    }
    public static void displayCounts(int [] counts){
        for (int i = 0; i < counts.length; i++) {
            if((i+1)%10==0){
                System.out.println((char)(i+'a')+ " - " + counts[i]+  "     ");
            }
            else
                System.out.print((char)(i+'a')+ " - " +counts[i]+"     " );
        }
        }
    }

