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
		
		setPreferredSize(new Dimension(240,323));
		
		try {
			name = ImageIO.read(new File(getClass().getResource("Name.png").toURI()));

			happy = ImageIO.read(new File(getClass().getResource("javier_happy.jpg").toURI()));
			thinking = ImageIO.read(new File(getClass().getResource("javier_thinking.jpg").toURI()));
			worry = ImageIO.read(new File(getClass().getResource("javier_worried.jpg").toURI()));
			sorry = ImageIO.read(new File(getClass().getResource("javier_sorry.jpg").toURI()));
			
		} catch (IOException | NullPointerException ex) {
			System.out.print(ex);
		} 
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if(status == 1) {
			g.drawImage(happy, 0, 0, 240,323, this);
		} else if (status == 2) {
			g.drawImage(thinking, 0, 0, 240,323, this);
		} else if (status == 3) {
			g.drawImage(worry, 0, 0, 240,323, this);
		} else if (status == 4) {
			g.drawImage(sorry, 0, 0, 240,323, this);
		} else {
			g.drawImage(name, 0, 0, 240,323, this);
		}
		
	}
	public void changeState(int value) {
		status = value;
		repaint();
	}
}