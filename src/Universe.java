import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Universe extends JFrame
{

    //Create Needed panels and labels
    //private JLabel labelOne = new JLabel("Carter");
    //private JLabel labelTwo= new JLabel("Conner");
    private JLabel labelThree = new JLabel("Abhi");
    private JLabel labelFour = new JLabel("Daniel");
    private JSlider sliderOne = new JSlider();
    Companion c = null; //added by CK
    
    //private JPanel panelOne = new JPanel();

    private JPanel panelThree = new JPanel();
    private JPanel panelFour = new JPanel();


    private JPanel bottomPanel = new JPanel();
    private JPanel topPanel = new JPanel();

    public Universe()
    {
        TutorPanel panelTwo;
        panelTwo = new TutorPanel();
        
    
 		try {
 			c = new Companion();
 		} catch (URISyntaxException e) {
 			e.printStackTrace();
 		}//
 		
        //Create action listener to listen for changes in the sliders state
        sliderOne.addChangeListener(new ChangeListener() {
        
        	public void stateChanged(ChangeEvent e) {
                System.out.println( sliderOne.getValue());
                changeLabelVisibility();
                panelTwo.changeState(sliderOne.getValue());
                c.changeState(sliderOne.getValue());
            }
        });

        c.setBackground(Color.yellow);
        c.setBorder(BorderFactory.createLineBorder(Color.black));
        panelTwo.setBackground(Color.BLUE);

        panelTwo.setBorder(BorderFactory.createLineBorder(Color.black));
        panelThree.setBackground(Color.CYAN);
        panelThree.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFour.setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());
        topPanel.setLayout(new GridLayout(2,2));

        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(c);
        topPanel.add(panelTwo);
        topPanel.add(panelThree);
        topPanel.add(panelFour);
        bottomPanel.add(sliderOne);

        sliderOne.setSnapToTicks(true);
        sliderOne.setValue(0);
        sliderOne.setMaximum(4);
        sliderOne.setMajorTickSpacing(1);
        sliderOne.setPaintTicks(true);
        sliderOne.setPaintLabels(true);
        sliderOne.setLabelTable(sliderOne.createStandardLabels(1));

        //c.add(labelOne);
        //panelTwo.add(labelTwo);
        panelThree.add(labelThree);
        panelFour.add(labelFour);

        setSize(700,700);
        sliderOne.setPreferredSize(new Dimension(getWidth() - getWidth() / 3 ,50));
        setVisible(true);
} public void changeLabelVisibility() {
    if (sliderOne.getValue() != 0) {
        //labelOne.setVisible(false);
        //labelTwo.setVisible(false);
        labelThree.setVisible(false);
        labelFour.setVisible(false);
    } else {
        //labelOne.setVisible(true);
        //labelTwo.setVisible(true);
        labelThree.setVisible(true);
        labelFour.setVisible(true);
    }
}
    public static void main(String[] args)
    {
        Universe frame = new Universe();


    }
}