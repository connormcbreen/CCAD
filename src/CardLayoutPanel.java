/*
Description: This class is used to navigate through other Jpanels needed for the main tutor panel including the calculator,
profile, and quiz panels.
 Assignment number: Project 3
 Recitation: Friday 12:55 p.m.
 Team number: 2
 author: Daniel Davidson
 Completeion time: 2 hours
 Version: 2.0
*/
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class CardLayoutPanel extends  JPanel {
    //Creating needed components
    static JPanel container = new JPanel();
    JPanel navigatorPanel = new JPanel();
    JPanel quizPanel = new JPanel();
    JPanel calculatorPanel = new JPanel();
    JPanel profilePanel = new JPanel();
    JPanel innerCalculatorPanel = new JPanel();
    JPanel logoutPanel = new JPanel();

    JButton backBtn1 = new JButton("Back");
    JButton backBtn2 = new JButton("Back");
    JButton backBtn3 = new JButton("Back");

    JButton profileBtn = new JButton("Profile");
    JButton calculatorBtn = new JButton("Calculator");
    JButton quizBtn = new JButton("Quiz");
    JButton logout = new JButton("Logout");
    JButton deleteAccount = new JButton("Delete Account");


    Profile user = new Profile();
    JLabel nameLbl;
    JLabel emailLbl;
    JLabel scoreLbl = new JLabel("Score");

    static CardLayout layout = new CardLayout();
    //Constructor

    public CardLayoutPanel(Quiz quiz, Calculator calc, Profile prof)
    {
        Color greenColor = new Color(98, 136, 146);
        setLayout(new BorderLayout());
        navigatorPanel.setLayout(new GridLayout(4,1));
        navigatorPanel.add(profileBtn);
        navigatorPanel.add(calculatorBtn);
        navigatorPanel.add(quizBtn);
        navigatorPanel.add(logoutPanel);
        logoutPanel.setLayout(new GridLayout(1,2));
        logoutPanel.setBackground(greenColor);
        logoutPanel.add(logout);
        logoutPanel.add(deleteAccount);

        nameLbl = new JLabel("Name: " + prof.getName());
        emailLbl = new JLabel("Email: " + prof.getEmail());


        calculatorPanel.setLayout(new BorderLayout());
        //calculatorPanel.add(backBtn2, BorderLayout.NORTH);
        backBtn2.setForeground(Color.white);

        backBtn2.setBorder( new EmptyBorder( 3, 5, 30, 5 ) );
        calculatorPanel.setBackground(greenColor);
        calculatorPanel.add(innerCalculatorPanel, BorderLayout.CENTER);
        innerCalculatorPanel.setBackground(Color.white);

        profilePanel.add(backBtn3);
        profilePanel.setBackground(greenColor);
        profilePanel.setLayout(new GridLayout(4,1));
        profilePanel.add(nameLbl);
        profilePanel.add(emailLbl);
        profilePanel.add(scoreLbl);

        container.setLayout(layout);
//Assigning each sub panel a name to call in the card layout
        container.add(navigatorPanel,"1");
        container.add(quiz, "2");
        //container.add(calc, "3");
        container.add(profilePanel, "4");
        add(container);
//Set default panel
        layout.show(container, "1");
//Create all needed action listeners
        backBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "1");

            }
        });
        backBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "1");

            }
        });
        backBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "1");

            }
        });
        profileBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "4");

            }
        });
        calculatorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame();
                JPanel panelpopUp = new JPanel();
                panelpopUp.setLayout(new CardLayout());
                Calculator calc = new Calculator();

                frame.setVisible(true);
                frame.setSize(400,400);
                panelpopUp.add(calc);
                frame.add(panelpopUp);


            }
        });
        quizBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "2");

            }
        });
        logout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Universe newUniverse = new Universe();

            }
        });
        deleteAccount.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Universe newUniverse = new Universe();
            }
        });
        setVisible(true);

    }
    public static void resetPanel()
    {
        layout.show(container, "1");
    }
}
