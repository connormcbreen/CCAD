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
