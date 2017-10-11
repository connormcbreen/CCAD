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

	private JButton Button0;
	private JButton Button1;
	private JButton Button2;
	private JButton Button3;
	private JButton Button4;
	private JButton Button5;
	private JButton Button6;
	private JButton Button7;
	private JButton Button8;
	private JButton Button9;
	private JButton Buttonans;
	private JButton Buttonequal;
	private JButton Buttonpercent;
	private JButton Buttondecimal;
	private JButton Buttonadd;
	private JButton Buttonsub;
	private JButton Buttonmult;
	private JButton Buttondiv;
	private JButton Buttonclear;
        public JButton returnToMenu;
	
	private JTextField test;
	private JTextField textfieldn1;
	private JTextField textfieldn2;
	private JTextField textfieldans;
	
	public double n1;
	public double n2;
    
	buttonListener B;

public Calculator() {
	
	
	String answer = ("answer");
	Buttonadd = new JButton("+");
	Buttonsub = new JButton("-");
	Buttonmult = new JButton("*");
	Buttondiv  = new JButton("/");
	Buttonequal = new JButton("=");
	Buttonpercent = new JButton("%");
	Buttondecimal = new JButton(".");
	Buttonclear = new JButton("C");
	returnToMenu = new JButton("Return to menu");
        
	//Numbers buttons
	/* Button0 = new JButton("0");
	 Button1 = new JButton("1");
	 Button2 = new JButton("2");
	 Button3 = new JButton("3");
	 Button4 = new JButton("4");
	 Button5 = new JButton("5");
	 Button6 = new JButton("6");
	 Button7 = new JButton("7");
	 Button8 = new JButton("8");
	 Button9 = new JButton("9");
	*/
	
	
	test = new JTextField();
	textfieldn1 = new JTextField();
	textfieldn1.setEditable(true);
	
	textfieldn2 = new JTextField();
	textfieldn2.setEditable(true);
	
	textfieldans = new JTextField();


	//Actionlisteners
	//N = new numberListener();
	B = new buttonListener();
	//Set the layout and the design
	setBackground(Color.white);
	setLayout(new GridLayout(3,3));
	
	// Adds all the numbers and symbols in the panel
	add(textfieldn1);
	
	add(textfieldn2);
	//textfieldn2.addActionListener(A);
	
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
	add(Buttonequal);
        returnToMenu.addActionListener(B);
        add(returnToMenu);
	
	
	/*add(Button1);
	add(Button2);
	add(Button3);
	add(Button4);
	add(Button5);
	add(Button6);
	add(Button7);
	add(Button8);
	add(Button9);
	add(Button0); */
	//add(Buttondecimal);
	//add(Buttonpercent);
}

public void updateState(int num) {

	if (num == 0) {
		/*Button0.addActionListener(N);
		Button1.addActionListener(N);
		Button2.addActionListener(N);
		Button3.addActionListener(N);
		Button4.addActionListener(N);
		Button5.addActionListener(N);
		Button6.addActionListener(N);
		Button7.addActionListener(N);
		Button8.addActionListener(N);
		Button9.addActionListener(N);*/
	}
}





public double Add(double x, double y) {
	double result;
	result = x + y;
	return result;
}

public double Sub(double x, double y) {
	double result;
	result = x - y;
	return result;
}
public double Mult(double x, double y){
	double result;
	result = x * y;
	return result;
}

public double Div(double x, double y) {
	double result;
	result = x / y;
	return result;
}


public class buttonListener implements ActionListener {

	
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == Buttonadd) {
			n1 = Double.parseDouble(textfieldn1.getText());
			n2 = Double.parseDouble(textfieldn2.getText());
			String ans = Double.toString(Add(n1, n2));
			textfieldans.setText(ans);
		}
		if(event.getSource() == Buttonsub) {
			n1 = Double.parseDouble(textfieldn1.getText());
			n2 = Double.parseDouble(textfieldn2.getText());
			String ans = Double.toString(Sub(n1, n2));
			textfieldans.setText(ans);
		}
		if(event.getSource() == Buttonmult) {
			n1 = Double.parseDouble(textfieldn1.getText());
			n2 = Double.parseDouble(textfieldn2.getText());
			String ans = Double.toString(Mult(n1, n2));
			textfieldans.setText(ans);
		}
		if(event.getSource() == Buttondiv) {
			n1 = Double.parseDouble(textfieldn1.getText());
			n2 = Double.parseDouble(textfieldn2.getText());
			String ans = Double.toString(Div(n1, n2));
			textfieldans.setText(ans);
		}
		if(event.getSource() == Buttonclear) {
			textfieldn1.setText("");
			textfieldn2.setText("");
			textfieldans.setText("");
		}
                if(event.getSource() == returnToMenu)
                {
                    CardLayoutPanel.resetPanel();
                }
	}
	
}
}




