package GUI_Based_Programming;

import javax.swing.*;
import java.awt.*;

public class PaintcomponentMethodUsingJPanel extends JFrame {
    public PaintcomponentMethodUsingJPanel() {
        add(new NewPanel());
    }

    public static void main(String[] args) {
        PaintcomponentMethodUsingJPanel frame=new PaintcomponentMethodUsingJPanel();
        frame.setTitle("Paint Component Method ");
        frame.setSize(1000,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

class NewPanel extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawLine(0,0,400,400);
    }
}