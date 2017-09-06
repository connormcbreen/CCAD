import java.awt.*;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.swing.*;

public class Test extends JFrame {

	public Test() {
		
		Companion c = null;
		try {
			c = new Companion();
		} catch (URISyntaxException e) {
			
			e.printStackTrace();
		}
		this.add(c);
		this.pack();
		this.setVisible(true);
		int input = 0;
		Scanner scan = new Scanner(System.in);
		
		while(input != -1) {
			System.out.print("Give input");
			input = scan.nextInt();
			c.changeState(input);
		}
		

	}
	
	public static void main(String[] args) {
		Test gui = new Test();
		
	}
	
}
