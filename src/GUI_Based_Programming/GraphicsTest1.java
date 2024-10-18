package GUI_Based_Programming;

import javax.swing.*;
import java.awt.*;

public class GraphicsTest1 extends JFrame {
    private JLabel jlblBanner =new JLabel("Banner");
    public GraphicsTest1(){
        add(jlblBanner);
        System.out.println(jlblBanner.getGraphics());
    }

    public static void main(String[] args) {
        GraphicsTest1 frame =new GraphicsTest1();
        frame.setTitle("Graphic LINE Test");
        frame.setSize(1000,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(null,"Delay on Purpose / Click OK to Dismiss");
        Graphics graphics =frame.jlblBanner.getGraphics();
        graphics.drawLine(0,0,500,500);
        graphics.draw3DRect(200,200,50,80,isDefaultLookAndFeelDecorated());
    }
}
