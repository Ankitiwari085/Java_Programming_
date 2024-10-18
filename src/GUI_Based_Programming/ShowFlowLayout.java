package GUI_Based_Programming;
import javax.swing.*;
import java.awt.*;

public class ShowFlowLayout  extends JFrame {
public  ShowFlowLayout(){
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT,20,40);
            setLayout(layout);
            add(new JLabel("First Name : "));
            add(new JTextField(10));
            add(new JLabel("Middle Name :"));
            add(new JTextField(5));
            add(new JLabel("Last Name : "));
            add(new JTextField(10));
            add(new JButton("Okay"));
            add(new JButton("Cancel"));
}

    public static void main(String[] args) {
        ShowFlowLayout frame =new ShowFlowLayout();
        frame.setTitle("Practice FLOW Layout");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
