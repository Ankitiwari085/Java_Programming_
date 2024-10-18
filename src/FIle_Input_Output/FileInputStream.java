package FIle_Input_Output;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream  output = new FileOutputStream("temp.dat");
        for (int i = 0; i < 11; i++) {
            output.write(i);
        }
        output.close();

        java.io.FileInputStream input = new java.io.FileInputStream("temp.dat");
        int value ;
        while ((value = input.read()) != -1){
            System.out.print(value +"  ");
        }
        input.close();


//
//        FileOutputStream  output = new FileOutputStream("tem.txt");
//        for (int i = 0; i < 11; i++) {
//            output.write(i);
//        }
//        output.close();
//
//        java.io.FileInputStream input = new java.io.FileInputStream("tem.txt");
//        int value ;
//        while ((value = input.read()) != -1){
//            System.out.print(value +"  ");
//        }
//        input.close();
    }
}
