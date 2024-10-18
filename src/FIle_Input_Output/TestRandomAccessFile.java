package FIle_Input_Output;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRandomAccessFile {
    public static void main(String[] args)  throws IOException {
        RandomAccessFile inOut =new RandomAccessFile("InOut.dat","rw");
        inOut.seek(40);
        System.out.println(inOut.getFilePointer());
        System.out.println(inOut.read());
        System.out.println(inOut.getFilePointer());

//        System.out.println(inOut.length());
//        for (int i = 0; i < 50; i++) {
//            inOut.write(i);
//        }
//        inOut.seek(0);
//        int value ;
//        while(( value = inOut.read())  != -1){
//            System.out.print(value+" , ");
//        }

        inOut.setLength(300);
        inOut.seek(200);
        System.out.println(inOut.read());
        System.out.println("\n Size: "+inOut.length());
        inOut.close();
    }
}
