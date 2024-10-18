package GUI_Based_Programming;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class JLabelPractice  {
    public static void main(String[] args) {

        ImageIcon  image =new ImageIcon("src/GUI_Based_Programming/CollegeImage.jpg");
        ImageIcon imageIcon =new ImageIcon("src/GUI_Based_Programming/Ankit_Image.jpg");
        ImageIcon imagelogo =new ImageIcon("src/GUI_Based_Programming/GECLogo.png");

        Border border = BorderFactory.createLineBorder(Color.yellow,10);


        JLabel label =new JLabel();
        label.setText("Gandhi Engineering College ");
        label.setIcon(imagelogo);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(Color.green);
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setFont(new Font("MV-Boli",Font.PLAIN,30));
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);

        JFrame frame = new JFrame("Label Practice ");
        frame.setSize(1500,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setIconImage(imageIcon.getImage());
        frame.add(label);
    }
}
