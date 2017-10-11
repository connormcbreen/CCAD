/*
Creator: Daniel Davidson
Description: This class is designed to be a navigation panel for the calculator, lessons, and profile that will all display
in the botton left corner of the JFrame. 
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

    JButton backBtn1 = new JButton("Back");
    JButton backBtn2 = new JButton("Back");
    JButton backBtn3 = new JButton("Back");

    JButton profileBtn = new JButton("Profile");
    JButton calculatorBtn = new JButton("Calculator");
    JButton quizBtn = new JButton("Quiz");
    Profile user = new Profile();
    JLabel nameLbl;
    JLabel emailLbl;
    JLabel scoreLbl = new JLabel("Score");

    static CardLayout layout = new CardLayout();
//Constructor
    public CardLayoutPanel()
    {   
    }
    public CardLayoutPanel(Quiz quiz, Calculator calc, Profile prof)
    {
        Color greenColor = new Color(98, 136, 146);
        setLayout(new BorderLayout());
        navigatorPanel.setLayout(new GridLayout(3,1));
        navigatorPanel.add(profileBtn);
        navigatorPanel.add(calculatorBtn);
        navigatorPanel.add(quizBtn);
        
         nameLbl = new JLabel("Name:" + prof.getName());
         emailLbl = new JLabel("Email:" + prof.getEmail());

        //quizPanel.add(backBtn1);
        //quizPanel.setBackground(greenColor);

        calculatorPanel.setLayout(new BorderLayout());
        calculatorPanel.add(backBtn2, BorderLayout.NORTH);
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
        container.add(calc, "3");
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
                layout.show(container, "3");
            }
        });
        quizBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.show(container, "2");
            }
        });

        setVisible(true);

    }
    public static void resetPanel()
        {
            layout.show(container, "1");
        }
}
