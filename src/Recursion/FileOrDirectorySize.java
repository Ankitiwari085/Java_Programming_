package Recursion;

import java.io.File;
import java.util.Scanner;

public class FileOrDirectorySize {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the File Or Directory For Getting Its Size : ");
        String directory = input.nextLine();
        System.out.println("The Size of the File is  : "+ getSize(new File(directory))+" bytes");
    }

    public static long getSize(File file){
        long size =0;
        if(file.isDirectory()){
            File [] files =file.listFiles();
            for (int i = 0; i < files.length; i++) {
                size += getSize(files[i]);
            }
        }
        else
            size += file.length();

        return  size;
    }
}
