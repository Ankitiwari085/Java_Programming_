package Practice_On_OOPS_By_Book;

public class StringBuilderOrStringBufferpractice {
    public static void main(String[] args) {
        StringBuffer stringBuffer =new StringBuffer();
        System.out.println("The Capacity of initialise StringBuffer Object :- "+stringBuffer.capacity());
        stringBuffer.append("Welcome to Java Family ");
        System.out.println(stringBuffer);
     //  StringBuffer  reverseString =stringBuffer.reverse();


       // System.out.println(stringBuffer);
        //System.out.println(reverseString);

        stringBuffer.replace(16,stringBuffer.length(),"World");
        System.out.println(stringBuffer);
        System.out.println(stringBuffer.capacity());
        System.out.println(stringBuffer.length());
        stringBuffer.delete(16,stringBuffer.length());
        System.out.println(stringBuffer);

        System.out.println(stringBuffer.charAt(14));
        stringBuffer.trimToSize();
        System.out.println(stringBuffer.capacity());
        System.out.println(stringBuffer.length());
    }

}
