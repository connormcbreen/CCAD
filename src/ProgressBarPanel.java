import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JPanel;

public class ProgressBarPanel extends JPanel {

	ProgressBar bar;
	public ProgressBarPanel(ProgressBar bar) {
		setLayout(new BorderLayout());
		this.bar = bar;
		add(bar.getPanel(), BorderLayout.CENTER);
	}
}
