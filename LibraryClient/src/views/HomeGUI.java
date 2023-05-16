/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import libraryclientupdate.LibraryClient;

/**
 *
 * @author User
 */
public class HomeGUI extends JFrame implements ActionListener {

    public JPanel panelCenter, panelTop;
    public JButton btnLoan, btnLearner, btnBook;
    public JLabel lblHeader;
    public JLabel lblImage;
    public JLabel lblPROM;
    Font textFont = new Font("Courier", Font.BOLD, 25);
    Color textColor = new Color(246, 255, 248);

    public HomeGUI() {
        super("Cput Bursary Application Login");
        panelCenter = new JPanel();
        panelTop = new JPanel();

        btnBook = new JButton("Book");
        btnBook.setPreferredSize(new Dimension(240, 50));
        btnBook.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));

        btnLearner = new JButton("Learner");
        btnLearner.setPreferredSize(new Dimension(240, 50));
        btnLearner.setBorder(BorderFactory.createLineBorder(textColor, 1, true));

        btnLoan = new JButton("Loan");
        btnLoan.setPreferredSize(new Dimension(240, 50));
        btnLoan.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));

        lblHeader = new JLabel("", SwingConstants.RIGHT);
        lblHeader.setFont(textFont);
        lblHeader.setBounds(150, 150, 200, 25);

        lblImage = new JLabel();
        lblPROM = new JLabel("");
    }

    public void setGUI() {
        

        this.setLayout(new GridLayout(3, 3));
        panelCenter.setLayout(null);
        panelTop.setLayout(new GridLayout(1, 3));

        panelTop.add(lblPROM);
        panelTop.add(lblImage);
        lblImage.setBounds(500, 200, 1920, 1080);
        panelTop.add(lblHeader);

        panelCenter.add(btnBook);
        btnBook.setBounds(50, 160, 300, 40);
        btnLearner.setBounds(50, 210, 300, 40);
        btnLoan.setBounds(50, 260, 300, 40);
        panelCenter.add(btnLearner);
        panelCenter.add(btnLoan);

        this.setLayout(new BorderLayout());
        this.add(panelTop, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        btnBook.addActionListener(this);
        btnLearner.addActionListener(this);
        btnLoan.addActionListener(this);    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnBook)) {
            BookGUI g = new BookGUI();
            g.setGUI();
            dispose();
        } else if (e.getSource().equals(btnLearner)) {
            LearnerGUI j = new LearnerGUI();
            j.setGUI();
            dispose();
        } else if (e.getSource().equals(btnLoan)) {
            LoanGUI j = new LoanGUI();
            j.setGUI();
            dispose();
        }
    }
}
