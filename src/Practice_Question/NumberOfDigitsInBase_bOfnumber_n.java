package Practice_Question;

public class NumberOfDigitsInBase_bOfnumber_n {
  public static void main(String []args){

      int number = 10;
      int base =2;
      int Total_digits= (int)(Math.log(number)/ Math.log(base)+1);

      System.out.println(Total_digits);
  }

}
