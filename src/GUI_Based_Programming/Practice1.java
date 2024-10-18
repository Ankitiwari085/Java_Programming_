package GUI_Based_Programming;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class Practice1 extends JFrame {
     public Practice1(){
        JPanel panel1= new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton leftButton =new JButton("Left");
        JButton centerButton =new JButton("Center");
        JButton rightButton = new JButton("Right");

        Font font =new Font("TimesRoman",Font.BOLD,20);
        leftButton.setFont(font);
        rightButton.setFont(font);
        centerButton.setFont(font);

        leftButton.setBackground(Color.cyan);
        centerButton.setBackground(Color.cyan);
        rightButton.setBackground(Color.cyan);


        leftButton.setForeground(Color.black);
        centerButton.setForeground(Color.black);
        rightButton.setForeground(Color.BLACK);

        leftButton.setToolTipText("Left Button Is Avaialble Here...");
        centerButton.setToolTipText("Center Button Is Available Here ...");
        rightButton.setToolTipText("Right Button Is Here...");

        panel1.add(leftButton);
        panel1.add(centerButton);
        panel1.add(rightButton);


         TitledBorder titledBorder =new TitledBorder("Click Button");
         panel1.setBorder(titledBorder);

         JPanel panel2 =new JPanel(new FlowLayout(FlowLayout.LEFT));
         JButton redButton =new JButton("RED BUTTON");
         JButton orangeButton =new JButton("ORANGE BUTTON");

         redButton.setBackground(Color.RED);
         orangeButton.setBackground(Color.ORANGE);

         redButton.setToolTipText("Red Button Is Available Here...");
         orangeButton.setToolTipText("Orange Button Is Available Here...");

         redButton.setFont(font);
         orangeButton.setFont(font);

         panel2.add(redButton);
         panel2.add(orangeButton);

         TitledBorder titledBorderForCOlor =new TitledBorder("Color Button");
        panel2.setBorder(titledBorderForCOlor);


        setLayout(new GridLayout(3,2,5,5));

        add(panel1);
      add(panel2);


    }

   public static void main(String[] args) {
      Practice1 frame =new Practice1();
      frame.setSize(500,500);
      frame.setTitle("Practicing GUI Components");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);

   }
}
