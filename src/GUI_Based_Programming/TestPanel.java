package GUI_Based_Programming;

import javax.swing.*;
import java.awt.*;

public class TestPanel extends JFrame {
    public TestPanel(){
        JPanel panel1 =new JPanel();
        panel1.setLayout(new GridLayout(4,3));
        for (int i = 1; i <= 9; i++) {
            JButton numButton = new JButton(" "+i);
            numButton.setBackground(Color.BLACK);
            numButton.setFont(new Font("Serif",Font.BOLD,20));
            panel1.add(numButton);
        }
        JButton zeroButton=new JButton("0");
        zeroButton.setBackground(Color.BLACK);
        zeroButton.setFont(new Font("Serif", Font.BOLD , 20));
        panel1.add(zeroButton);


        panel1.add(new JButton("Start"));
        panel1.add(new JButton("Stop"));

        JPanel panel2= new JPanel();
        panel2.setLayout(new BorderLayout());

        JTextField timeField =new JTextField("Time To Be Displayed Here...");
        panel2.add(timeField,BorderLayout.NORTH);
        timeField.setFont(new Font("Serif",Font.BOLD,20));
        timeField.setBackground(Color.CYAN);

        panel2.add(panel1,BorderLayout.CENTER);
        add(panel2,BorderLayout.EAST);
        JButton textFieldButton =new JButton("Keep Your Food Here ..");
        textFieldButton.setFont(new Font("SansSerif",Font.BOLD,30));
        textFieldButton.setBackground(Color.BLACK);
        add(textFieldButton,BorderLayout.CENTER);

    }


    public static void main(String[] args) {
        TestPanel frame =new TestPanel();
        frame.setTitle("THE FRONT VIEW OF MICROWAVE OVEN");
        frame.setSize(1000,800);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
