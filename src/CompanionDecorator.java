/** 
* CompanionDecorator implements the Companion interface and allows us to use the HelperCompanion class
* Assignment number: Recitation Project 3
* Completion time: 1 hour
* 
* @author Carter
* @version 1.0
*/

import javax.swing.*;

public class CompanionDecorator implements Companion {
	
	protected Companion c;
	
	public void add(Companion c) {
		this.c = c;
	}
	
	@Override
	public void setUp() {
		this.c.setUp(); //sets up whatever Companion is called - helper or basic	
	}
	

}
