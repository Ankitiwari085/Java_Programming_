package GUI_Based_Programming;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class ImageIconTEST extends JFrame {
    private  ImageIcon  image =new ImageIcon("src/GUI_Based_Programming/CollegeImage.jpg");
    public ImageIconTEST(){
        setLayout(new FlowLayout(FlowLayout.CENTER));
        JLabel label =new JLabel(image);
        add(label);

//        JPanel loginPanel=new JPanel();
//        JTextField userId =new JTextField(" ");
//        userId.setFont(new Font("Serif",Font.BOLD,20));
//        loginPanel.setBorder(new TitledBorder("USER ID :"));
//        loginPanel.add(userId);
//
//
//
//
//        JPanel passwordPanel=new JPanel();
//        JTextField password =new JTextField(" ");
//        password.setFont(new Font("Serif",Font.BOLD,20));
//        loginPanel.setBorder(new TitledBorder("Password :"));
//        passwordPanel.add(password);
//
//
//        setLayout(new GridLayout(3,1,5,5));
//        add(loginPanel);
//        add(passwordPanel);



    }

    public static void main(String[] args) {
        ImageIconTEST frame =new ImageIconTEST();
        frame.setTitle("GANDHI ENGINNERING COLLEGE");
        frame.setSize(1000,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
