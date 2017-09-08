//Daniel Davidson
//9/8/17
//CSE 360
//Universe.java


import javax.swing.*;
import java.awt.*;
import java.net.URISyntaxException;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Universe extends JFrame
{

    //Create Needed panels and labels and instantiate them

    private JLabel labelFour = new JLabel("Daniel Davidson");
    private JSlider sliderOne = new JSlider();

    Companion companionPanel = null;
    Assessor assessorPanel = null;
    TutorPanel tutorPanel = null;


    private JPanel panelFour = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel topPanel = new JPanel();

    //Constructor
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
                    //Call change state on each panel class
                    tutorPanel.changeState(sliderOne.getValue());
                    companionPanel.changeState(sliderOne.getValue());
                    assessorPanel.updateState(sliderOne.getValue());
                }
            }
        });

        //Style the JPanel with borders
        companionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        tutorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        assessorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFour.setBorder(BorderFactory.createLineBorder(Color.black));


        //Set layout for main panel consisting of 2 smaller panels
        setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());
        topPanel.setLayout(new GridLayout(2,2));
        //manage layouts
        add(topPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        //add all panels
        topPanel.add(companionPanel);
        topPanel.add(tutorPanel);
        topPanel.add(assessorPanel);
        topPanel.add(panelFour);
        bottomPanel.add(sliderOne);

        //Style the slider and set to zero to start
        sliderOne.setSnapToTicks(true);
        sliderOne.setValue(0);
        sliderOne.setMaximum(4);
        sliderOne.setMajorTickSpacing(1);
        sliderOne.setPaintTicks(true);
        sliderOne.setPaintLabels(true);
        sliderOne.setLabelTable(sliderOne.createStandardLabels(1));
        panelFour.add(labelFour);
        setSize(700,700);
        sliderOne.setPreferredSize(new Dimension(getWidth() - getWidth() / 3 ,50));
        setVisible(true);

        //Method to set name name visibility
    } public void changeLabelVisibility() {
    if (sliderOne.getValue() != 0) {

        labelFour.setVisible(false);
    } else {

        labelFour.setVisible(true);
    }
}
    public static void main(String[] args)
    {
        Universe frame = new Universe();


    }
}