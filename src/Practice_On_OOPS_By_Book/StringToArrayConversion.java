package Practice_On_OOPS_By_Book;

import java.util.Arrays;

public class StringToArrayConversion {
    public static void main(String[] args) {
        String str ="WELCOME";
        char [] chars  = new char[20];
//        chars =str.toCharArray();
//        for (char c : chars){
//          //  System.out.print(" '" +c+ "' ");
//        }
        str.getChars(0,str.length(),chars,0);
       // char [] addingArray =new char[10];
        String addingCharToararray ="To JAVA";
        addingCharToararray.getChars(0,addingCharToararray.length(),chars,7);
        for (char c : chars){
              System.out.print(" '" +c+ "' ");
        }


//        char []character ={'a','n','k','i','t'};
//        String arrayTostring = String.copyValueOf(character);
//       /// System.out.println(arrayTostring);
//
//        int []  number={2,2,0,1,2,9,2,0,1,5};
//        String intTostring = Arrays.toString(number);
//      // System.out.println(intTostring);



    }
}
