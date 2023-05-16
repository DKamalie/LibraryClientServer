/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import domain.Book;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import libraryclientupdate.LibraryClient;

/**
 *
 * @author User
 */
public class IssueBookGUI extends JFrame implements ActionListener {

    private ArrayList<String> listL = null;
    private JFrame frame;
    private JLabel lblLoanId;
    private JLabel lblLearnerCode;
    private JLabel lblISBN;

    private JTextField txtLoanId;

    private JComboBox boxLearnerCode;
    private JComboBox boxISBN;

    private JButton btnIssueBook;
    private JButton btnBack;
    
    private ArrayList<String> listB = null;
    
    public IssueBookGUI() {
        super("Add Book");

        frame = new JFrame();

        lblLoanId = new JLabel("Loan ID");
        lblLearnerCode = new JLabel("Learner Code");
        lblISBN = new JLabel("ISBN");

        txtLoanId = new JTextField();

        boxLearnerCode = new JComboBox();
        boxISBN = new JComboBox();

        btnIssueBook = new JButton("Issue Book");
        btnBack = new JButton("Back");

    }

    public void setGUI() {
        LibraryClient.sendToServer("populate Combo Learner Code");
        LibraryClient.sendToServer("populate Combo ISBN");

        listL = LibraryClient.readComboLearnerIDFromServer();
        System.out.println(listL);
        System.out.println("Between fail");
        listB = LibraryClient.readComboISBNFromServer();

        frame.setLayout(null);

        lblLoanId.setBounds(50, 50, 100, 60);
        frame.add(lblLoanId);
        
        lblLearnerCode.setBounds(50, 100, 100, 60);
        frame.add(lblLearnerCode);
        
        lblISBN.setBounds(50, 150, 100, 60);
        frame.add(lblISBN);
        
        txtLoanId.setBounds(200, 70, 150, 20);
        frame.add(txtLoanId);
        
        boxLearnerCode.setBounds(200, 120, 150, 20);
        frame.add(boxLearnerCode);
        
        boxISBN.setBounds(200, 170, 150, 20);
        frame.add(boxISBN);
        
        btnIssueBook.setBounds(50, 300, 100, 30);
        frame.add(btnIssueBook);
        
        btnBack.setBounds(200, 300, 100, 30);
        frame.add(btnBack);
                
                
        
        btnIssueBook.addActionListener(this);
        btnBack.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnIssueBook) {

        } else if (e.getSource() == btnBack) {

        }
    }

    public static void main(String[] args) {
        new IssueBookGUI().setGUI();
    }

}
