package GUI_Based_Programming;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FileDialogueOpen {
    public static void main(String[] args) throws FileNotFoundException {
        JFileChooser fileChooser =new JFileChooser();
        if(fileChooser.showOpenDialog(null)==fileChooser.getFileSelectionMode()){
            File file = fileChooser.getSelectedFile();
            Scanner input =new Scanner(file);
            while(input.hasNext()){
                System.out.println(input.nextLine());
            }
            input.close();
        }
        else {
            System.out.println("File Not Found..");
        }
    }
}
