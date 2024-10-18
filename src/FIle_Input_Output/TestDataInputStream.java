package FIle_Input_Output;

import java.io.*;
import java.io.FileInputStream;
import java.util.Scanner;

public class TestDataInputStream {
    public static void main(String[] args) throws IOException {

        DataOutputStream output  = new DataOutputStream(new FileOutputStream("dataInputStream.dat"));

//        output.writeUTF("Ankit Tiwari");
//        output.writeDouble(8.3);
//        output.writeUTF("Amit Tiwari");
//        output.writeDouble(8.4);

        Scanner scan =new Scanner(System.in);
        int i=3;
        while(i!=0){
            System.out.println("Enter the Name  :-  ");
            output.writeUTF(scan.nextLine());
            System.out.println("Enter the CGPA :- ");
            output.writeDouble(scan.nextDouble());

            scan.nextLine();
            i--;
        }
        output.close();
        DataInputStream input =new DataInputStream(new FileInputStream("dataInputStream.dat"));
         while(input.available() != 0){
             System.out.println("Name  : "+ input.readUTF() + "  CGPA :  "+ input.readDouble());
         }
         input.close();
         scan.close();
    }
}
