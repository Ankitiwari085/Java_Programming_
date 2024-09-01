package Practice_Question;

import javax.swing.JOptionPane;
public class InputUsingDialogueBox {
    public static void main(String[] args) {
        String input=JOptionPane.showInputDialog(null,"Enter the Name :- ","Taking Input",JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null,input);
    }

}
