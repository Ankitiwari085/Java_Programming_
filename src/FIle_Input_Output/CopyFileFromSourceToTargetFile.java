package FIle_Input_Output;

import java.io.*;
import java.io.FileInputStream;

public class CopyFileFromSourceToTargetFile {
    public static void main(String[] args)  throws IOException {
        File sourceFile =new File("C:\\Users\\ankit\\IdeaProjects\\ankit_java_practice_With_IntelliJ\\src\\FIle_Input_Output\\sourcefile.txt");
        File targetFile = new File("C:\\Users\\ankit\\IdeaProjects\\ankit_java_practice_With_IntelliJ\\src\\FIle_Input_Output\\targetfile.txt");

        if(!sourceFile.exists()){
            System.out.println(" Source File Not Found");
            System.exit(0);
        }

        if(!targetFile.exists()){
            System.out.println(" Target File Not Found");
            System.exit(0);
        }

        BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));
        BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));

        int r;
        while ((r=input.read()) != -1){
            output.write((byte)r);

        }
        input.close();
        output.close();
        System.out.println("File Copied  Successfully...");

    }
}
