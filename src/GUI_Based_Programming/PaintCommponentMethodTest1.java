package GUI_Based_Programming;

import javax.swing.*;
import java.awt.*;

public class PaintCommponentMethodTest1 extends JFrame {
    public PaintCommponentMethodTest1(){
        add(new NewLabel("Banner"));
    }

    public static void main(String[] args) {
        PaintCommponentMethodTest1 frame =new PaintCommponentMethodTest1();
        frame.setTitle("Paint Component Method ");
        frame.setSize(1000,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
class NewLabel  extends JLabel {
    public NewLabel(String text){
        super(text);
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawLine(0,0,500,500);
    }
}