import javax.swing.*;
public class CompanionDecorator implements Companion {
	public void add(Companion c) {
		
	}
	
	@Override
	public void doSomething(JComponent panel) {
		this.c.doSomething(panel);
	}

}
