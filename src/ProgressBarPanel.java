import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ProgressBarPanel extends JPanel {

	ProgressBar bar;
	public ProgressBarPanel(ProgressBar bar) {
		setLayout(new FlowLayout());
		this.bar = bar;
		add(bar.getPanel());
	}
}
