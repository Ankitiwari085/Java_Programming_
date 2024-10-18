package Multithreading;

public class Practice1 {
    public static void main(String[] args) {
        PrintChar printChar = new PrintChar("Ankit",100);
        PrintChar printChar1 = new PrintChar("Tiwari",100);
        PrintNum printNum = new PrintNum(100);

        Thread thread =new Thread(printChar);
        Thread thread1 = new Thread(printChar1);
        Thread thread2 = new Thread(printNum);

        thread.start();
        thread1.start();
        thread2.start();
    }
}

    class PrintChar implements  Runnable{

    private String StringToPrint;
    private int times;

    public PrintChar (String StringToPrint , int times){
        this.StringToPrint = StringToPrint;
        this.times =times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print("  "+ StringToPrint);
        }
    }

}

    class PrintNum implements  Runnable{

    private int times;

    public PrintNum ( int times){
        this.times =times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print("  "+i);
        }
    }

}