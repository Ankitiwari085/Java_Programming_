package GUI_Based_Programming;
import javax.swing.*;
import java.awt.*;

public class FramePractice {
    public static void main(String[] args) {
//        JFrame frame = new JFrame("First Frame ");
//        frame.setSize(1500,800);
//        frame.setLocationRelativeTo(null);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        //frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
//        frame.setResizable(false);
//        frame.setVisible(true);
//
//
//        ImageIcon imageIcon =new ImageIcon("src/GUI_Based_Programming/Ankit_Image.jpg");
//        frame.setIconImage(imageIcon.getImage());
//        frame.getContentPane().setBackground(Color.CYAN);

//        JButton jButton =new JButton("OKAY");
//        frame.add(jButton);
//        jButton.setBackground(Color.BLACK);
//        jButton.setForeground(Color.yellow);



        MyFrame frame = new MyFrame();
    }
}
class MyFrame extends JFrame{
    public MyFrame(){
        this.setSize(1500,800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //this.setResizable(false);
        this.setVisible(true);


        ImageIcon imageIcon =new ImageIcon("src/GUI_Based_Programming/Ankit_Image.jpg");
        this.setIconImage(imageIcon.getImage());
        this.getContentPane().setBackground(Color.CYAN);

    }
}
