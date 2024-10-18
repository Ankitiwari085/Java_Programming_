package GUI_Based_Programming;

import javax.swing.*;
import java.awt.*;

public class ShowGridLayout extends JFrame{
    public ShowGridLayout(){
        GridLayout layout = new GridLayout(6,2,4,4);
        setLayout(layout);
        add(new JLabel("First Name : "));
        add(new JTextField(10));
        add(new JLabel("Middle Name :"));
        add(new JTextField(10));
        add(new JLabel("Last Name : "));
        add(new JTextField(10));
        add(new JButton("Okay"));
        add(new JButton("Cancel"));
    }



    public static void main(String[] args) {
        ShowGridLayout frame =new ShowGridLayout();
        frame.setTitle("Practice GRID Layout");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
