import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Companion extends JPanel {
	
	int status = 0;
	private BufferedImage name, happy, thinking, worry, sorry;
	
	
	public Companion() throws URISyntaxException {
		setLayout(new FlowLayout());
		
		setPreferredSize(new Dimension(250,250));
		
		try {
			happy = ImageIO.read(new File(getClass().getResource("Happy.jpg").toURI()));
			name = ImageIO.read(new File(getClass().getResource("Name.png").toURI()));
			
		} catch (IOException | NullPointerException ex) {
			System.out.print(ex);
		} 
		//setBackground(Color.red );
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(status == 1) {
			g.drawImage(happy, 0, 0, 250,250, this);
		} else if (status == 2) {
		
		} else if (status == 3) {
			
		} else if (status == 4) {
			
		} else {
			g.drawImage(name, 0, 0, 250,250, this);
		}
		
	}
	public void changeState(int value) {
		status = value;
		repaint();
	}
}
