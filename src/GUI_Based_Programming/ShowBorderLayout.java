package GUI_Based_Programming;

import javax.swing.*;
import java.awt.*;

public class ShowBorderLayout extends JFrame {
    public ShowBorderLayout(){
        setLayout(new BorderLayout(5,5));

        JButton jButton =new JButton("CENTRE");
        jButton.setBackground(Color.darkGray);   // For the  Coloring
        jButton.setForeground(Color.BLUE);


        Font font =new Font("Monospaced",Font.BOLD+Font.ITALIC,30); // Providing Font to the
        jButton.setFont(font);                                                      //  Given Button by using Font Class...

        add(new JButton("East"),BorderLayout.EAST);
        add(new JButton("West"),BorderLayout.WEST);
        add(new JButton("North"),BorderLayout.NORTH);
        add(new JButton("South"),BorderLayout.SOUTH);
        add(jButton,BorderLayout.CENTER);




    }

    public static void main(String[] args) {
        ShowBorderLayout frame =new ShowBorderLayout();
        frame.setTitle("BORDER LAYOUT Practice");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
