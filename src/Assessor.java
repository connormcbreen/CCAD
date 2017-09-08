// Author: Abhishek Pate;
// Recitation Friday 12:50 PM
// Project 1
// Assessor
// Description:This class contains four panels and four different ways to get inputs from the user. It shows a dialog box after the.
//			   user gives input. There are two panels in // Author: Abhishek Pate;
// Recitation Friday 12:50 PM
// Project 1
// Assessor
// Description:This class contains  four different ways to get inputs from the user which are checkboxes, buttons, dropmenu,and textfield. It shows a dialog box after the.
//			   user gives input.
//
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class Assessor extends JPanel {
    JComboBox dropmenu;

    //All the buttons that are used in this class
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    JButton tbutton; //This is the "enter" button

    // All the checkboxes that are used in this class
    JCheckBox cb1 ;
    JCheckBox cb2 ;
    JCheckBox cb3 ;
    JCheckBox cb4;

    //All the textfields and textareas that are used in this class
    JTextArea tf;
    JTextField name;

    JPanel textPanel;

    public Assessor() {
        setBackground(Color.cyan);
        textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(2,1));
        add(textPanel);
        String Options[] = {"Option 1", "Option 2", "Option 3", "Option 4"};
        dropmenu =   new JComboBox(Options);

        //All the buttons are defined here
        b1 = new JButton("Option 1");
        b2 = new JButton("Option 2");
        b3 = new JButton("Option 3");
        b4 = new JButton("Option 4");
        tbutton = new JButton("Enter");

        //all the checkboxes are defined here
        cb1 = new JCheckBox();
        cb2 = new JCheckBox();
        cb3 = new JCheckBox();
        cb4 = new JCheckBox();

        //All the textfields and textareas are defined here
        tf = new JTextArea();
        name = new JTextField("Abhishek Patel");
    }

    //This method takes the input from user in 4 different ways depending on the position of the slider.
    public void updateState(int num) {
        buttonlistener A = new buttonlistener();
        textlistener B = new textlistener();
        menulistener C = new menulistener();
        checkboxlistener D = new checkboxlistener();

        //this displays the name
        if(num == 0) {
            removeAll();
            updateUI();
            name.setVisible(true);
            add(name);
            setVisible(true);



        }
        // This creates the dropdown menu if the slider is at position 1
        if (num == 1) {
            removeAll();
            updateUI();
            add(dropmenu);
            dropmenu.setVisible(true);
            dropmenu.addActionListener(C);
            setVisible(true);



        }
        //this creates 4 buttons if the slider position is at 2
        else if(num == 2) {
            removeAll();
            updateUI();
            setVisible(true);
            //listener B = new listener();

            b1.setBorderPainted(true);
            b1.addActionListener(A);
            add(b1);
            b2.setBorderPainted(true);
            b2.addActionListener(A);
            add(b2);
            b3.setBorderPainted(true);
            b3.addActionListener(A);
            add(b3);
            b4.setBorderPainted(true);
            b4.addActionListener(A);
            add(b4);
            b1.setVisible(true);
            b2.setVisible(true);
            b3.setVisible(true);
            b4.setVisible(true);



        }
        // this creates 4 checkboxes if the slider is at position at 3
        else  if(num == 3) {
            removeAll();
            updateUI();
            cb1.setText("Option 1");
            add(cb1);
            cb1.setBorderPainted(true);
            cb1.addActionListener(D);
            cb2.setText("Option 2");
            cb2.setBorderPainted(true);
            cb2.addActionListener(D);
            add(cb2);
            cb3.setText("Option 3");
            cb3.setBorderPainted(true);
            cb3.addActionListener(D);
            add(cb3);
            cb4.setText("Option 4");
            cb4.setBorderPainted(true);
            cb4.addActionListener(D);
            add(cb4);
            cb1.setVisible(true);
            cb2.setVisible(true);
            cb3.setVisible(true);
            cb4.setVisible(true);
            setVisible(true);



        }
        //this creates a textarea and a button if the slider is at position 4
        else if (num == 4) {
            removeAll();
            updateUI();
            setVisible(true);
            textPanel.setVisible(true);
            add(textPanel);
            Border blackline;

            blackline = BorderFactory.createLineBorder(Color.black);
            tf.setForeground(Color.black);
            tf.setBorder(blackline);
            tf.setEditable(true);
            tf.setBackground(Color.red);
            tf.setVisible(true);
            tbutton.setVisible(true);
            tbutton.addActionListener(B);
            textPanel.add(tf);
            textPanel.add(tbutton);
            setBackground(Color.cyan);



        }
        updateUI();
    }

    public class menulistener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String cbinput = dropmenu.getSelectedItem().toString();
            if(event.getSource() == dropmenu ) {

                JOptionPane.showMessageDialog(null, cbinput);
            }

        }
    }
    public  class buttonlistener implements ActionListener
    {

        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == b1 || event.getSource() == b2|| event.getSource() == b3 || event.getSource() == b4) {
                String input = ((AbstractButton) event.getSource()).getText();
                JOptionPane.showMessageDialog(null, input);
            }


        }

    }

    public  class checkboxlistener implements ActionListener
    {

        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == cb1 || event.getSource() == cb2|| event.getSource() == cb3 || event.getSource() == cb4) {
                String input = ((AbstractButton) event.getSource()).getText();
                JOptionPane.showMessageDialog(null, input);
            }


        }

    }

    public class textlistener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if(event.getSource() == tbutton)
            {
                String input = tf.getText();
                JOptionPane.showMessageDialog(null, input);
            }
        }
    }


}