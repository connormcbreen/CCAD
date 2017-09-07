// Author: Abhishek Pate;
// Recitation Friday 12:50 PM
// Project 1
// Assessor
// Description:This class contains four panels and four different ways to get inputs from the user. It shows a dialog box after the.
//			   user gives input. There are two panels in 





import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;    

//Comstructor
public class Assessor extends JFrame {
	JFrame f  = new JFrame();		//just to test my panels 
	JPanel P = new JPanel();		// This is the main panel.
	Font myFont = new Font("Courier", Font.BOLD, 22);
	
	Assessor() {
		P.setLayout(new GridLayout(2,2));
		f.add(P);
		f.setVisible(true);
		
		
	}
	
	public static void main(String[] args) {
		Assessor myAssessor = new Assessor();
		myAssessor.dropmenu();
		myAssessor.checkboxes();
		myAssessor.buttons();
		myAssessor.text();
		
	}
	// This method creates a dropdown menu with 4 options. 
	public void dropmenu() {
		String Options[] = {"Option 1", "Option 2", "Option 3", "Option 4"};
		JComboBox cb = new JComboBox(Options);
		cb.setBackground(Color.cyan);
		cb.setForeground(Color.black);
		P.add(cb);
		listener a = new listener();
		cb.addActionListener(a);
		
		
	}
	//This method creates 4 checkboxes and adds them to a panel with grid layout. When any of the 4 check boxes is clicked a dialog box pops up.  
	public  void checkboxes() {
		JCheckBox cb1 = new JCheckBox();
		JPanel P1 = new JPanel();
		P1.setLayout(new GridLayout(2,2));		//A panel with grid layout with 4 checkboxes in it. . P2 is added to the P panel which is the main panel

			cb1.setText("Option 1");
			P1.add(cb1);
		   cb1.setBorderPainted(true);
		   cb1.setBackground(Color.cyan);
		   cb1.setForeground(Color.black);
		   listener a = new listener();
		   cb1.addActionListener(a);
		   
		   
		   
		   
		   JCheckBox cb2 = new JCheckBox();
		   cb2.setText("Option 2");
		   cb2.setBorderPainted(true);
		   cb2.setBackground(Color.cyan);
		   cb2.setForeground(Color.black);
		   cb2.addActionListener(a);
		   P1.add(cb2);
		   
		   JCheckBox cb3 = new JCheckBox();
		   cb3.setText("Option 3");
		   cb3.setBorderPainted(true);
		   cb3.setBackground(Color.cyan);
		   cb3.setForeground(Color.black);
		   cb3.addActionListener(a);
		   P1.add(cb3);
		   
		   JCheckBox cb4 = new JCheckBox();
		   cb4.setText("Option 4");
		   cb4.setBorderPainted(true);
		   cb4.setBackground(Color.cyan);
		   cb4.setForeground(Color.black);
		   cb4.addActionListener(a);
		   P1.add(cb4);
		   P.add(P1);
		   
}
	//This method creates 4 buttons which are added to a panel with a gridlayout. When the button is pressed a dialog box pops up. 
	public void buttons () {
		
		listener A = new listener();
		
		JPanel P2 = new JPanel();
		P2.setLayout(new GridLayout(2,2));		//A panel with grid layout with 4 buttons in it. P2 is added to the P panel which is the main panel
		
		
		JButton b1 = new JButton("Option 1");
		b1.setBackground(Color.cyan);
		b1.setForeground(Color.black);
		b1.setBorderPainted(true);
		b1.addActionListener(A);
		P2.add(b1);
		
		
		JButton b2 = new JButton("Option 2");
		b2.setBackground(Color.cyan);
		b2.setForeground(Color.black);
		b2.setBorderPainted(true);
		b2.addActionListener(A);
		P2.add(b2);
		
		JButton b3 = new JButton("Option 3");
		b3.setBackground(Color.cyan);
		b3.setForeground(Color.black);
		b3.setBorderPainted(true);
		b3.addActionListener(A);
		P2.add(b3);
		
		JButton b4 = new JButton("Option 4");
		b4.setBackground(Color.cyan);
		b4.setForeground(Color.black);
		b4.setBorderPainted(true);
		b4.addActionListener(A);
		P2.add(b4);
		P.add(P2);
		
		
		
	}
	
	//this method creates a JTextField and a JButton. A user can type in the field and then press the button to show a dialog box
	public void text() {
		 Border border = BorderFactory.createLineBorder(Color.black);
		JTextField tf = new JTextField();
		JButton button = new JButton("Enter");
		button.setBackground(Color.cyan);
		button.setForeground(Color.black);
		JPanel P3 = new JPanel();
		listener A = new listener();
		tf.setBackground(Color.white);
		tf.setForeground(Color.black);
		tf.setSize(20,20);
		tf.setBorder(border);
		P3.setLayout(new GridLayout(1,1));
		//tf.setFocusable(true);
		Border blackline;
		blackline = BorderFactory.createLineBorder(Color.black);
		tf.setForeground(Color.black);
		tf.setBorder(blackline);
		button.addActionListener(A);
		P3.add(tf);
		P3.add(button);
		
		
		P.add(P3);
	}
	
	
	public void updateState(int num) {
		
		switch(Integer.valueOf(1)) {
		case 0:
			System.out.println("Abhi");
			break;
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
	
	
}