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

    Companion companionPanel = null; //added by CK
    Assessor assessorPanel = null;
    TutorPanel tutorPanel = null;


    private JPanel panelFour = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel topPanel = new JPanel();

    public Universe()
    {


        tutorPanel = new TutorPanel();
        assessorPanel = new Assessor();


        try {
            companionPanel = new Companion();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }




        //Create action listener to listen for changes in the sliders state
        sliderOne.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                if ( !( sliderOne.getValueIsAdjusting() ) ) {
                    System.out.println(sliderOne.getValue());
                    changeLabelVisibility();
                    tutorPanel.changeState(sliderOne.getValue());
                    companionPanel.changeState(sliderOne.getValue());
                    assessorPanel.updateState(sliderOne.getValue());
                }
            }
        });


        companionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        tutorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        assessorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFour.setBorder(BorderFactory.createLineBorder(Color.black));
        setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());
        topPanel.setLayout(new GridLayout(2,2));

        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        topPanel.add(companionPanel);
        topPanel.add(tutorPanel);
        topPanel.add(assessorPanel);
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
//        assessorPanel.add(labelThree);
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