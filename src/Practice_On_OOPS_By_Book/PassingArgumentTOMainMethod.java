package Practice_On_OOPS_By_Book;

public class PassingArgumentTOMainMethod {
    public static void main(String[] args) {
        String [] string = {"Ankit","Amit","Rahul","Jeet"};
       A.main(string);
    }
}
class A{
    public static void main(String[] args) {
      for (String arg: args){
          System.out.print(arg+ " ");
      }
    }
}
