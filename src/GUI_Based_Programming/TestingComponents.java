package GUI_Based_Programming;
import javax.swing.*;

public class TestingComponents {
    public static void main(String[] args) {




        JButton jbtOK =new JButton("OK");
        JLabel jlbl =new JLabel("Enter Your Name :- ");
        JTextField jtxtfld =new JTextField("Type your Name Here...");
        JCheckBox jCheckBox =new JCheckBox("18+");
        JRadioButton jRadioButton =new JRadioButton("Male  ");
        JComboBox jComboBox =new JComboBox( new String [] { "Red","Green","Blue"});



        JPanel panel1 =new JPanel();

        panel1.add(jlbl);
        panel1.add(jtxtfld);
        panel1.add(jCheckBox);
        panel1.add(jRadioButton);
        panel1.add(jComboBox);
        panel1.add(jbtOK);




        JFrame frame1 =new JFrame();
        frame1.add(panel1);
        frame1.setTitle("Welcome To GUI  Component ");
        frame1.setLocation(300,0);
        frame1.setSize(1000,800);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setVisible(true);
    }
}
