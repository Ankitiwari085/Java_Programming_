package GUI_Based_Programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPractice {
     static JButton button = new JButton();
    public static void main(String[] args) {
     ImageIcon  imageIcon =new ImageIcon("src/GUI_Based_Programming/image1.png");
     ImageIcon   collegeImage = new ImageIcon("src/GUI_Based_Programming/CollegeImage.jpg");

     JLabel label =new JLabel("Gandhi Engineering College ");
     label.setIcon(collegeImage);
     label.setText("Gandhi Engineering College ");
     label.setVisible(false);
     label.setFont(new Font("Comic Sans",Font.BOLD,25));
     label.setVerticalTextPosition(JLabel.TOP);
        label.setHorizontalTextPosition(JLabel.CENTER);
     label.setForeground(Color.cyan);
     label.setIconTextGap(-50);

        button.setText("!! Who Fucked You !!");
        button.setFont(new Font("Comic Sans",Font.BOLD,30));
        button.setFocusable(false);
        button.setBounds(200,200,500,500);
        button.setBorder(BorderFactory.createLineBorder(Color.yellow,10));
        button.setIcon(imageIcon);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setBackground(Color.PINK);
        button.setForeground(Color.RED);
        button.setIconTextGap(-55);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == button){
                    System.out.println("Ohh Yesss!!");
                    label.setVisible(true);
                    button.setVisible(false);
                }
            }
        });


        JFrame frame =new JFrame();
        frame.setTitle("Button Practice");
        frame.setSize(1000,900);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.PINK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(button);
        frame.add(label);

    }

}
