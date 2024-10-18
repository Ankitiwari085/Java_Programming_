package FIle_Input_Output;
import java.util.Scanner;
import java.io.*;

public class scannerFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file =new File("src/File_Input_Output/BasicMethodPracticeFile.txt");
        Scanner input =new Scanner(file);
        while (input.hasNext()){

            System.out.println(input.nextLine());

        }
             input.close();
    }
}
