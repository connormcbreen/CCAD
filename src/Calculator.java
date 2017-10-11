// This class is a basic calculator. The student can add, subtract,multiply and divide.
// It can also handle decimals.
// Assignment number: Project 3
// Recitation: Friday 12:55 p.m.
// Team number: 2
// author: Abhishek Patel
// Completeion time: 3 hours
// Version: 2.0


import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator extends JPanel {

    // Operator buttons
    private JButton Buttonans;
    private JButton Buttonexp;
    private JButton Buttonpercent;
    private JButton Buttondecimal;
    private JButton Buttonadd;
    private JButton Buttonsub;
    private JButton Buttonmult;
    private JButton Buttondiv;
    private JButton Buttonclear;


    private JTextField textfieldn1;
    private JTextField textfieldn2;
    private JTextField textfieldans;

    // operands
    public double n1;
    public double n2;

    //button listener for the operator buttons
    buttonListener B;

    public Calculator() {


        String answer = ("answer");
        Buttonadd = new JButton("+");
        Buttonsub = new JButton("__");
        Buttonmult = new JButton("*");
        Buttondiv  = new JButton("/");
        Buttonexp = new JButton("e");
        Buttonpercent = new JButton("%");
        Buttondecimal = new JButton(".");
        Buttonclear = new JButton("C");

        textfieldn1 = new JTextField();
        textfieldn1.setEditable(true);
        textfieldn2 = new JTextField();
        textfieldn2.setEditable(true);
        textfieldans = new JTextField();
        B = new buttonListener();

        //Set the layout and the design
        setBackground(Color.white);
        setLayout(new GridLayout(3,2));

        //Adds the buttons and textfields to the panel.
        add(textfieldn1);
        add(textfieldn2);
        add(textfieldans);
        add(Buttonclear);
        Buttonclear.addActionListener(B);
        add(Buttonadd);
        Buttonadd.addActionListener(B);
        add(Buttonsub);
        Buttonsub.addActionListener(B);
        add(Buttonmult);
        Buttonmult.addActionListener(B);
        add(Buttondiv);
        Buttondiv.addActionListener(B);
        add(Buttonexp);
        Buttonexp.addActionListener(B);
    }


    public void updateState(int num) {

        if (num == 0) {

        }
    }

    // Adds two numbers entered by the user
    public double Add(double x, double y) {
        double result;
        result = x + y;
        return result;
    }
    // Subtraction
    public double Sub(double x, double y) {
        double result;
        result = x - y;
        return result;
    }
    // Multiplication
    public double Mult(double x, double y){
        double result;
        result = x * y;
        return result;
    }
    // Division
    public double Div(double x, double y) {
        double result;
        result = x / y;
        return result;
    }

    // This actionlistener class performs the operation depending on the button clicked.
// it listens to all the buttons.
    public class buttonListener implements ActionListener {


        public void actionPerformed(ActionEvent event) {
            // Add button
            if(event.getSource() == Buttonadd) {
                n1 = Double.parseDouble(textfieldn1.getText());
                n2 = Double.parseDouble(textfieldn2.getText());
                String ans = Double.toString(Add(n1, n2));
                textfieldans.setText(ans);
            }
            //Subtraction button
            if(event.getSource() == Buttonsub) {
                n1 = Double.parseDouble(textfieldn1.getText());
                n2 = Double.parseDouble(textfieldn2.getText());
                String ans = Double.toString(Sub(n1, n2));
                textfieldans.setText(ans);
            }
            //multiplication  button
            if(event.getSource() == Buttonmult) {
                n1 = Double.parseDouble(textfieldn1.getText());
                n2 = Double.parseDouble(textfieldn2.getText());
                String ans = Double.toString(Mult(n1, n2));
                textfieldans.setText(ans);
            }
            // division button
            if(event.getSource() == Buttondiv) {
                n1 = Double.parseDouble(textfieldn1.getText());
                n2 = Double.parseDouble(textfieldn2.getText());
                String ans = Double.toString(Div(n1, n2));
                textfieldans.setText(ans);
            }
            // clear button
            if(event.getSource() == Buttonclear) {
                textfieldn1.setText("");
                textfieldn2.setText("");
                textfieldans.setText("");
            }
            // Exponential  button
            if(event.getSource() == Buttonexp) {
                n1 = Double.parseDouble(textfieldn1.getText());
                n2 = Double.parseDouble(textfieldn2.getText());
                String ans = Double.toString(Math.pow(n1,n2));
                textfieldans.setText(ans);
            }


        }

    }
}

