package FIle_Input_Output;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AddressBook extends JFrame {

    final static  int NAME_SIZE =32;
    final  static  int STREET_SIZE =32;
    final static int CITY_SIZE =20;
    final static  int STATE_SIZE =15;
    final static int ZIP_SIZE = 5;
    final static int RECORD_SIZE =(NAME_SIZE+STREET_SIZE+CITY_SIZE+STATE_SIZE+ZIP_SIZE);
    private RandomAccessFile raf;


    private JTextField jtName = new JTextField(NAME_SIZE);
    private JTextField jtStreet = new JTextField(STREET_SIZE);
    private  JTextField jtCity = new JTextField(CITY_SIZE);
    private JTextField jtState = new JTextField(STATE_SIZE);
    private  JTextField jtZip = new JTextField(ZIP_SIZE);


    private  JButton jbAdd = new JButton("ADD");
    private  JButton jbFirst = new JButton("First");
    private  JButton jbNext = new JButton("Next");
    private  JButton jbPrevious = new JButton("Previous");
    private  JButton jbLast = new JButton("Last");


    public AddressBook (){
        try {
            raf =new RandomAccessFile("AddressBook.dat","rw");
        }
        catch (IOException ex){
            System.out.println("Error: "+ex);
            System.exit(0);
        }


        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(3,1));
        p1.add(new JLabel("Name: "));
        p1.add(new JLabel("Street:"));
        p1.add(new JLabel("City"));


        JPanel jpState = new JPanel();
        jpState.setLayout(new BorderLayout());
        jpState.add(new JLabel("State"),BorderLayout.WEST);
        jpState.add(jtState,BorderLayout.CENTER);


        JPanel jpZip =new JPanel();
        jpZip.setLayout(new BorderLayout());
        jpZip.add(new JLabel("ZIP"),BorderLayout.WEST);
        jpZip.add(jtZip,BorderLayout.CENTER);

        JPanel p2=new JPanel();
        p2.setLayout(new BorderLayout());
        p2.add(jpState,BorderLayout.WEST);
        p2.add(jpZip,BorderLayout.CENTER);


        JPanel p3 =new JPanel();
        p3.setLayout(new BorderLayout());
        p3.add(jtCity,BorderLayout.CENTER);
        p3.add(p2,BorderLayout.EAST);


        JPanel p4 =new JPanel();
        p4.setLayout(new GridLayout(3,1));
        p4.add(jtName);
        p4.add(jtState);
        p4.add(p3);


        JPanel jpAddress =new JPanel(new BorderLayout());
        jpAddress.add(p1,BorderLayout.WEST);
        jpAddress.add(p4,BorderLayout.CENTER);

        jpAddress.setBorder(new BevelBorder(BevelBorder.RAISED));

        JPanel jpButton = new JPanel();
        jpButton.add(jbAdd);
        jpButton.add(jbFirst);
        jpButton.add(jbNext);
        jpButton.add(jbPrevious);
        jpButton.add(jbLast);


        add(jpAddress,BorderLayout.CENTER);
        add(jpButton,BorderLayout.SOUTH);



        jbAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                writeAddress();
            }
        });


        jbFirst.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(raf.length()>0)
                        readAddress(0);

                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });

        jbNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    long currentPosition = raf.getFilePointer();
                    if(currentPosition <raf.length())
                        readAddress(currentPosition);
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });


        jbPrevious.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    long currentPosition = raf.getFilePointer();
                    if(currentPosition-2*RECORD_SIZE  > 0)
                        readAddress(currentPosition-2*2*RECORD_SIZE);
                    else
                        readAddress(0);
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });

        jbLast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    long lastPosition =raf.length();
                    if(lastPosition > 0)
                        readAddress(lastPosition-2*RECORD_SIZE);
                }
                catch (IOException ex){
                    ex.printStackTrace();
                }
            }
        });

        try{
            if (raf.length()> 0)
                readAddress(0);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }
    public void writeAddress(){
        try{
            raf.seek(raf.length());
            FixedLengthStringIO.writeFixedLengthString(jtName.getText(),NAME_SIZE,raf);
            FixedLengthStringIO.writeFixedLengthString(jtStreet.getText(),STREET_SIZE,raf);
            FixedLengthStringIO.writeFixedLengthString(jtCity.getText(),CITY_SIZE,raf);
            FixedLengthStringIO.writeFixedLengthString(jtState.getText(),STATE_SIZE,raf);
            FixedLengthStringIO.writeFixedLengthString(jtZip.getText(),ZIP_SIZE,raf);
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public void readAddress(long position ) throws IOException{
        String name =FixedLengthStringIO.readFixedLengthString(NAME_SIZE,raf);
        String street = FixedLengthStringIO.readFixedLengthString(STREET_SIZE,raf);
        String city = FixedLengthStringIO.readFixedLengthString(CITY_SIZE,raf);
        String state =FixedLengthStringIO.readFixedLengthString(STATE_SIZE,raf);
        String zip =FixedLengthStringIO.readFixedLengthString(ZIP_SIZE,raf);

        jtName.setText(name);
        jtStreet.setText(street);
        jtCity.setText(city);
        jtState.setText(state);
        jtZip.setText(zip);
    }

    public static void main(String[] args) {

        AddressBook frame = new AddressBook();
        frame.pack();
        frame.setTitle("Address Book  ");
        frame.setSize(400,200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.PINK);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


class FixedLengthStringIO{
    public static  String  readFixedLengthString(int size, DataInput in) throws IOException{
        char [] chars = new char[size];
        for (int i = 0; i < size; i++) {
            chars[i]= in.readChar();
        }
        return new String (chars);
    }
    public static void writeFixedLengthString(String s , int size , DataOutput out) throws  IOException{
        char [] chars = new char[size];
         s.getChars(0,Math.min(s.length(),size),chars,0);
        for (int i = Math.min(s.length(),size); i < chars.length; i++) {
            chars[i]= ' ';
        }
     out.writeChars(new String(chars));
    }
}
