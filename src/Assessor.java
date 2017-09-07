// Author: Abhishek Pate;
// Recitation Friday 12:50 PM
// Project 1
// Assessor
// Description:This class contains four panels and four different ways to get inputs from the user. It shows a dialog box after the.
//			   user gives input. There are two panels in 





import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;


public class Assessor extends JPanel {
//    JFrame f  = new JFrame();		//just to test my panels
    JPanel P = new JPanel(); // This is the main panel.

//	Font myFont = new Font("Courier", Font.BOLD, 22);

    public Assessor() {
        P.setLayout(new GridLayout(2,2));
        P.setBackground(Color.yellow);
//        f.add(P);
       P.setVisible(true);


    }

//    public static void main(String[] args) {
//        Assessor myAssessor = new Assessor();
//        myAssessor.dropmenu();
////        myAssessor.checkboxes();
////        myAssessor.buttons();
////        myAssessor.text();
//        //myAssessor.updateState();
//    }

    public void dropmenu() {
        String Options[] = {"Option 1", "Option 2", "Option 3"};
        JComboBox cb = new JComboBox(Options);
        add(cb);


    }

    public  void checkboxes() {
        JCheckBox cb1 = new JCheckBox();
        JPanel P1 = new JPanel();
        P1.setLayout(new GridLayout(2,2));		//A panel with grid layout with 4 checkboxes in it. . P2 is added to the P panel which is the main panel

        cb1.setText("Option 1");
        P1.add(cb1);
        cb1.setBorderPainted(true);
        cb1.setBackground(Color.red);
        cb1.setForeground(Color.white);
        listener a = new listener();
        cb1.addActionListener(a);




        JCheckBox cb2 = new JCheckBox();
        cb2.setText("Option 2");
        cb2.setBorderPainted(true);
        cb2.setBackground(Color.red);
        cb2.setForeground(Color.white);
        //cb2.setFont(myFont);
        cb2.addActionListener(a);
        P1.add(cb2);
        //.setBounds(1000, 350, 200, 150);

        JCheckBox cb3 = new JCheckBox();
        cb3.setText("Option 3");
        cb3.setBorderPainted(true);
        cb3.setBackground(Color.red);
        cb3.setForeground(Color.white);
        // cb3.setFont(myFont);
        cb3.addActionListener(a);
        P1.add(cb3);

        JCheckBox cb4 = new JCheckBox();
        cb4.setText("Option 4");
        cb4.setBorderPainted(true);
        cb4.setBackground(Color.red);
        cb4.setForeground(Color.white);
        //cb4.setFont(myFont);
        cb4.addActionListener(a);
        P1.add(cb4);
        P.add(P1);

    }

    public void buttons () {

        listener A = new listener();

        JPanel P2 = new JPanel();
        P2.setLayout(new GridLayout(2,2));		//A panel with grid layout with 4 buttons in it. P2 is added to the P panel which is the main panel


        JButton b1 = new JButton("Option 1");
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.setBorderPainted(true);
        b1.addActionListener(A);
        P2.add(b1);


        JButton b2 = new JButton("Option 2");
        b2.setBackground(Color.blue);
        b2.setForeground(Color.white);
        b2.setBorderPainted(true);
        b2.addActionListener(A);
        P2.add(b2);

        JButton b3 = new JButton("Option 3");
        b3.setBackground(Color.blue);
        b3.setForeground(Color.white);
        b3.setBorderPainted(true);
        b3.addActionListener(A);
        P2.add(b3);

        JButton b4 = new JButton("Option 4");
        b4.setBackground(Color.blue);
        b4.setForeground(Color.white);
        b4.setBorderPainted(true);
        b4.addActionListener(A);
        P2.add(b4);
        P.add(P2);



    }
    public void text() {
        JTextArea tf = new JTextArea();
        textlistener A = new textlistener();
        tf.addKeyListener(A);
        Border blackline;
        blackline = BorderFactory.createLineBorder(Color.black);
        tf.setForeground(Color.black);
        tf.setBorder(blackline);
        P.add(tf);
    }


    public void updateState(int num) {

        switch(num) {
            case 1:
                dropmenu();
                break;
            case 2:
                checkboxes();
                break;
            case 3:
                buttons();
                break;
            case 4:
                text();
                break;
            default :
                System.out.println("Invalid option");

        }


    }
    //
    public  class listener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            JOptionPane.showMessageDialog(null, "Welcome");

        }
    }

    public class textlistener implements KeyListener {
        public void keyTyped(KeyEvent e) {
            if( e.getKeyCode() == KeyEvent.VK_ENTER ) {
                JOptionPane.showMessageDialog(null, "Welcome");
            }
        }

        @Override
        public void keyPressed(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

        @Override
        public void keyReleased(KeyEvent arg0) {
            // TODO Auto-generated method stub

        }

    }
}
	