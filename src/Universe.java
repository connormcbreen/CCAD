/**
*This class contains a CardLayout that holds two main JPanels, the first is a login screen that is used to
*hold user information for later use, the second is the main lesson frame consisting of small JPanels with their own functionalities.
*Assignment Number: Recitation Project 3
*Completeion time: 5 hours
*
*@author: Daniel Davidson
*@version: 3.0
*/
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.awt.event.WindowStateListener;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class Universe {

    //Components for container JFrame
    JFrame frame = new JFrame();
    JPanel container = new JPanel();
    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    public Boolean hasLoggedin = false;

    //Components for login panel
    private JLabel nameLbl = new JLabel("Name:");
    private JLabel emailLbl = new JLabel("Email:");
    private JLabel titleLbl = new JLabel("Please enter your information below to continue!");
    private JTextField nameEntry = new JTextField(15);
    private JTextField emailEntry = new JTextField(15);
    private JPanel smallPanel = new JPanel();
    private JPanel containerPanel = new JPanel();
    private JButton continueBtn = new JButton();
    private JRadioButton yesBtn = new JRadioButton("Yes");
    private JRadioButton noBtn = new JRadioButton("No");
    private JRadioButton yesRemember = new JRadioButton("Yes");
    private JRadioButton noRemember = new JRadioButton("No");
    private JLabel rememberMeLbl = new JLabel("Remember me");
    private JLabel yesOrNo = new JLabel("Would you like to have your tutor give you textual feedback while you're working?");


    //Components for main lesson Frame
    private JLabel labelFour = new JLabel("Daniel Davidson");
    CompanionPanel companionPanel = null;
    ControlCenter observable = ControlCenter.getInstance();
    //Assessor assessorPanel = null;
    Calculator calc = null;
    CardLayoutPanel cardPanel = null;
    Quiz quiz = null;
    Test test = null;
    Tutor tutorPanel = null;
    Profile userProfile = null;
    private JPanel panelFour = new JPanel();
    private JPanel bottomPanel = new JPanel();
    private JPanel topPanel = new JPanel();
    BasicCompanion basic;
    HelperCompanion helper;
    Grader grade = new Grader();
    ProgressBar bar = new ProgressBar();
    ProgressBarPanel progressBar = new ProgressBarPanel(bar);
    

    CardLayout layout = new CardLayout();

    //Constructor
    @SuppressWarnings("deprecation")
	public Universe(){
        tutorPanel = new Tutor(bar);
        quiz = new Quiz(tutorPanel, grade, bar);
        test = new Test();
        userProfile = new Profile();
        calc = new Calculator();
        JButton logout = new JButton("Logout");
        JButton deleteAccount = new JButton("Delete Account");

        cardPanel = new CardLayoutPanel(quiz, calc, userProfile, test, logout,deleteAccount);
        try {
	        	basic = new BasicCompanion();
	        	helper = new HelperCompanion();
        }catch(URISyntaxException e) {
        		System.out.print(e);
        }
        grade.addObserver(helper);
        grade.addObserver(basic);
        // assessorPanel = new Assessor();
        //companionPanel = new CompanionPanel(basic);
        //observable.addObserver(companionPanel);
        //Style the individual JPanel with borders
        //companionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        tutorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        quiz.setBorder(BorderFactory.createLineBorder(Color.black));
        //assessorPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        cardPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        panelFour.setBorder(BorderFactory.createLineBorder(Color.black));

        //Set a default opening size and layout
        frame.setPreferredSize(new Dimension(1000,1000));
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

       //This method is used to switch the panel being shown between the login screen and the main panel.
        logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                layout.show(container, "1");

            }
        });
        //This method shows the login panel and deletes the text file containing the users profile information.
        deleteAccount.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){

                layout.show(container, "1");

            }
        });


    }

//In the main method the first thing that is done is to read a file called userProfile which consists of the last users information and populates the
    //Textfields for the user as a remember me feature.
    public static void main(String[] args) {
        Universe system = new Universe();
        system.yesRemember.setSelected(true);
        try {

            FileReader fileReader = new FileReader("userProfile.txt"); //Read in file
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String firstLine;
            String secondLine;
            String thirdLine;
            firstLine = bufferedReader.readLine();
            //If remember me option is checked
            if (firstLine.toString().equalsIgnoreCase("1")) {

                System.out.println(firstLine);
                secondLine = bufferedReader.readLine();
                system.nameEntry.setText(secondLine);
                System.out.println(secondLine);
                thirdLine = bufferedReader.readLine();
                System.out.println(thirdLine);
                system.emailEntry.setText(thirdLine);
            }

            fileReader.close();
            //Exception handling
        }catch (FileNotFoundException ex){
            System.out.println("Error File Not Found");
        }catch (IOException ioexception){
                ioexception.printStackTrace();
        }



    }



    private void setupLoginFrame(){
        //Setting up login frame and components
    		ButtonGroup yesorno = new ButtonGroup();
    		yesorno.add(noBtn);
    		yesorno.add(yesBtn);
    		yesBtn.setSelected(true);

    		ButtonGroup rememberGroup = new ButtonGroup();
    		rememberGroup.add(noRemember);
    		rememberGroup.add(yesRemember);

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

        smallPanel.add(yesOrNo, constraint);
        constraint.gridy++;
        smallPanel.add(yesBtn, constraint);
        constraint.gridy++;
        smallPanel.add(noBtn, constraint);
        constraint.gridy++;
        smallPanel.add(rememberMeLbl);
        constraint.gridy++;
        smallPanel.add(yesRemember);
        constraint.gridy++;
        smallPanel.add(noRemember);
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
                if (hasLoggedin == false) {
                        if (yesBtn.isSelected()) {
                            hasLoggedin = true;
                            companionPanel = new CompanionPanel(helper, basic);
                            companionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
                        } else {
                            hasLoggedin = true ;
                            companionPanel = new CompanionPanel(basic);
                            companionPanel.setBorder(BorderFactory.createLineBorder(Color.black));
                        }
                    }
                		setupMainFrame();
                    userProfile.setName(nameEntry.getText());
                    userProfile.setEmail(emailEntry.getText());
                    ExportPrintable export = new ExportPrintable();
                    export.displayinfo(userProfile);
                    System.out.println("\n User name is: " + userProfile.name);
                    System.out.println("User email is: " + userProfile.email);
                    cardPanel.nameLbl.setText("Name: " + userProfile.getName());
                    cardPanel.emailLbl.setText("Email: " + userProfile.getEmail());

                            //Used to output the user information to a text file that will be read next time the program opens
                        if (yesRemember.isSelected()) {
                            try {
                                //Write file to be read upon rerun of program
                                PrintWriter newWriter = new PrintWriter("userProfile.txt", "UTF-8");
                                newWriter.println("1");
                                newWriter.println(userProfile.name);
                                newWriter.println(userProfile.email);
                                newWriter.close();
                            //Exception handling
                            }catch (UnsupportedEncodingException er) {
                                throw  new AssertionError("UTF-8 is unknown", er);
                            }
                            catch (FileNotFoundException exception) {
                                System.out.println("File not found");
                            }

                        }else if (noRemember.isSelected()){
                            try {
                                //Write file but do not remember for next time
                                PrintWriter newWriter = new PrintWriter("userProfile.txt", "UTF-8");
                                newWriter.println("0");
                                newWriter.println(userProfile.name);
                                newWriter.println(userProfile.email);
                                newWriter.close();
                            //Exception handling
                            }catch (UnsupportedEncodingException er) {
                                throw  new AssertionError("UTF-8 is unknown", er);
                            }
                            catch (FileNotFoundException exception) {
                                System.out.println("File not found");
                            }

                        } else {
                            return;

                    }

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
        topPanel.add(cardPanel);
        topPanel.add(progressBar);
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
                quiz.setWindowSize("min");
                quiz.resize();
            }
        }
    }
}

