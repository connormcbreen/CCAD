/*
Class: Universe.java
Creator: Daniel Davidson
Date: 10/2/2017
Description: This class contains a CardLayout that holds two main JPanels, the first is a login screen that is used to
hold user information for later use, the second is the main lesson frame consisting of small JPanels with their own functionalities.
Estimated hours: 12
*/
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Universe {

    //Components for container JFrame
    JFrame frame = new JFrame();
    JPanel container = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    //Components for login panel
    private JLabel nameLbl = new JLabel("Name:");
    private JLabel emailLbl = new JLabel("Email:");
    private JLabel titleLbl = new JLabel("Please enter your information below to continue!");
    private JTextField nameEntry = new JTextField(10);
    private JTextField emailEntry = new JTextField(10);
    private JPanel smallPanel = new JPanel();
    private JPanel containerPanel = new JPanel();
    private JButton continueBtn = new JButton();

    //Components for main lesson Frame
    private JLabel labelFour = new JLabel("Daniel Davidson");
    Companion companionPanel = null;
    //Assessor assessorPanel = null;
    Calculator calc = null;
    CardLayoutPanel cardPanel = null;
    Quiz quiz = null;
    Tutor tutorPanel = null;
    Profile userProfile = null;
    private JPanel panelFour = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel topPanel = new JPanel();

    CardLayout layout = new CardLayout();

    //Constructor
    public Universe(){
        tutorPanel = new Tutor();
        quiz = new Quiz(tutorPanel);
        userProfile = new Profile();
        calc = new Calculator();
        cardPanel = new CardLayoutPanel(quiz, calc, userProfile);
       // assessorPanel = new Assessor();
        try {
            companionPanel = new Companion();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        //Style the individual JPanel with borders
        companionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        tutorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        quiz.setBorder(BorderFactory.createLineBorder(Color.black));
        //assessorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFour.setBorder(BorderFactory.createLineBorder(Color.black));

        //Set a default opening size and layout
        frame.setPreferredSize(new Dimension(700,700));
        container.setLayout(layout);

        //Add two login panel and main lesson panel to container panel
        container.add(panel1,"1");
        container.add(panel2,"2");

        //Setting the default panel to be login panel upon first load
        layout.show(container, "1");

        frame.add(container);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

       setupLoginFrame();

       setupMainFrame();
       
    }



    public static void main(String[] args) {
        Universe system = new Universe();
    }

    private void setupLoginFrame(){
        //Setting up login frame and components
        panel1.setLayout(new BorderLayout());
        Color greenColor = new Color(98, 136, 146);
        Color offGreen = new Color(98,116,126);
        containerPanel.setBackground(greenColor);

        panel1.add(containerPanel, BorderLayout.CENTER);
        containerPanel.setLayout(new GridLayout(3,1));
        containerPanel.add(titleLbl);
        containerPanel.add(smallPanel);

        titleLbl.setBorder(new EmptyBorder(150,3,3,3));
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);

        smallPanel.setLayout(new GridBagLayout());
        smallPanel.setBackground(offGreen);

        GridBagConstraints constraint = new GridBagConstraints();
        constraint.insets.bottom = 10;

        constraint.gridx = 0;
        constraint.gridy = 0;
        constraint.anchor = GridBagConstraints.WEST;

        smallPanel.add(nameLbl, constraint);
        constraint.gridy++;
        smallPanel.add(emailLbl, constraint);

        constraint.gridx++;
        constraint.gridy = 0;

        smallPanel.add(nameEntry, constraint);
        constraint.gridy++;
        smallPanel.add(emailEntry, constraint);
        constraint.gridy++;

        smallPanel.add(continueBtn, constraint);
        continueBtn.setText("Continue");

        continueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nameEntry.getText().isEmpty() == true || emailEntry.getText().isEmpty() == true) {

                    titleLbl.setText("Some fields appear to be missing");
                    titleLbl.setForeground(Color.white);
                }else {
                    userProfile.setName(nameEntry.getText());
                    userProfile.setEmail(emailEntry.getText());
                    System.out.println("\n User name is: " + userProfile.name);
                    System.out.println("User email is: " + userProfile.email);
                    cardPanel.nameLbl.setText("Name: " + userProfile.getName());
                    cardPanel.emailLbl.setText("Email: " + userProfile.getEmail());
                    panel1.setVisible(false);
                    bottomPanel.setVisible(true);
                    layout.show(container, "2");
                }
            }
        });
    }

    private void setupMainFrame(){
        //Setting up main lesson frame

        panel2.setLayout(new BorderLayout());
        bottomPanel.setLayout(new FlowLayout());
        topPanel.setLayout(new GridLayout(2,2));

        //manage layouts
        panel2.add(topPanel, BorderLayout.CENTER);
        panel2.add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.setVisible(false);
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        bottomPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        //add all panels
        topPanel.add(companionPanel);
        topPanel.add(tutorPanel);
        //topPanel.add(conceptualQuestions);
       // topPanel.add(assessorPanel);
       // assessorPanel.updateState(1);
        topPanel.add(cardPanel);
        topPanel.add(panelFour);
        frame.addWindowStateListener(new maximizeButton());

        panelFour.add(labelFour);
        panel2.setSize(700,700);
        panel2.setVisible(false);

    }

    boolean flag = false;
    private class maximizeButton implements WindowStateListener
    {
        public void windowStateChanged(WindowEvent event)
        {
            int originalState;
            if(flag == false);
            {
                originalState = event.getNewState();
                flag = true;
            }
            if(event.getNewState() == frame.MAXIMIZED_BOTH)
            {
                System.out.println("max");
                tutorPanel.setWindowSize("max");
                tutorPanel.resize();
                quiz.setWindowSize("max");
                quiz.resize();
            }
            else if(event.getNewState() == originalState)
            {
                System.out.println("min");
                tutorPanel.setWindowSize("min");
                tutorPanel.resize();
                quiz.setWindowSize("max");
                quiz.resize();
            }
        }
    }
}