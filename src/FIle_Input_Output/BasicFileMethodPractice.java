package FIle_Input_Output;
import java.io.File;
import java.io.PrintWriter;
import java.util.Date;
public class BasicFileMethodPractice {
    public static void main(String[] args) throws Exception {
        File file =new File("src/File_Input_Output/BasicMethodPracticeFile.txt");
        System.out.println("Does File Exists :- "+ file.exists());
        System.out.println("LEngth of he File :- "+ file.length());
        System.out.println("Can WE Read The File :- "+file.canRead());
        System.out.println("The Absolute Path Of the File :- "+ file.getAbsolutePath());

//        PrintWriter printWriter =new PrintWriter("PrintWriter.txt");
//        printWriter.println("\n");
//        printWriter.print("Name : ");
//        printWriter.println("Umesh Tiwari ");
//        printWriter.print("Name :  Sindhu Tiwari ");
//        printWriter.close();

        
    }

}
