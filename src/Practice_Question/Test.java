package Practice_Question;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

                    Scanner in=new Scanner(System.in);
                    String input=in.nextLine();
//                String input = "this is a code for tedt purpose 5057 and 978";
                System.out.println("Input string: " + input);

                String[] tokens = input.split("\\D+"); // Split by non-digit characters
                int max =-1;

                for (String token : tokens) {
                    if (!token.isEmpty() && !token.contains("9")) {
                        int num = Integer.parseInt(token);
                        if (num > max) {
                            max = num;
                        }
                    }
                }

        System.out.println(max);
            }
        }

