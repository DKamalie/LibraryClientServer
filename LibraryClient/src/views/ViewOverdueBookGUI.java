/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import domain.Book;
import domain.Loan;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import libraryclientupdate.LibraryClient;

/**
 *
 * @author User
 */
public class ViewOverdueBookGUI extends JFrame implements ActionListener {

    private ArrayList<Loan> list = new ArrayList<Loan>();
    DefaultTableModel model;  

    private JLabel lblISBN;
    private JLabel lblHEADING;
    private JLabel lblAuthor;
    private JLabel lblshelfNumber;
    private JLabel lblTitle, lblGenre, lblAvaible, p4;
    private JButton testButton, btnExit;

    
//    private JPasswordField passwordInput;
    private JScrollPane pane;
    Font textFont = new Font("Courier", Font.BOLD, 30);
    Font textFont2 = new Font("Courier", Font.BOLD, 15);
    Color textColor = new Color(246, 255, 248);

    private JPanel panelTop, panelCenterL, panelCenterR, mainframe, test;

    private JTable overdueBooks;

    public ViewOverdueBookGUI() {
        super("Show Book");
//        this.list = list;
//        txtISBN.setText(list.toString());

        panelTop = new JPanel();
        panelTop.setBackground(Color.red);

        mainframe = new JPanel();
        mainframe.setBackground(Color.BLACK);

        panelCenterL = new JPanel();
//     panelCenterL.setBackground(Color.blue);

        panelCenterR = new JPanel();
        panelCenterR.setBackground(Color.YELLOW);

        test = new JPanel();

        lblHEADING = new JLabel("Book");
        lblHEADING.setFont(textFont);

        lblISBN = new JLabel("ISBN");
        lblISBN.setFont(textFont2);

        lblAuthor = new JLabel("Book Author");
        lblAuthor.setFont(textFont2);

        lblTitle = new JLabel("Book Title");
        lblTitle.setFont(textFont2);

        lblGenre = new JLabel("Book Category");
        lblGenre.setFont(textFont2);

        lblAvaible = new JLabel("Availiable for Loan: ");
        lblAvaible.setFont(textFont2);

        lblshelfNumber = new JLabel("Shelf Number: ");
        lblshelfNumber.setFont(textFont2);

        // Button
        testButton = new JButton("View Overdue Books");
        btnExit = new JButton("Exit");

//     txtAvaible = new TextField();
        //table
        
//        TableModel model;
        model = new DefaultTableModel();
        overdueBooks = new JTable(model);

        pane = new JScrollPane(overdueBooks, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        
 
    }

    public void setGUI() { 
        model.addColumn("ISBN");
        model.addColumn("daysOverdue");
        model.addColumn("totalPenaltyCost");
        //TOP
        panelTop.setLayout(new GridLayout(1, 1));
        panelTop.add(lblHEADING);

        //mainframe
        mainframe.setBorder(new TitledBorder("MAIN"));
        mainframe.setLayout(new GridLayout(1, 1));
        mainframe.add(panelCenterR);

        panelCenterL.setLayout(new GridLayout(1, 2));
        //RIGHT PANEL
        panelCenterR.setLayout(new BorderLayout());
       
        testButton.setPreferredSize(new Dimension(100, 30));
        btnExit.setPreferredSize(new Dimension(100, 30));
        panelCenterR.add(pane, BorderLayout.CENTER);

        this.setLayout(new BorderLayout());
        this.add(panelTop, BorderLayout.NORTH);
        this.add(mainframe);
        
//        testButton.setBounds(100, 500, 70, 70);
//        panelCenterR.add(testButton, BorderLayout.SOUTH);
        panelCenterR.add(panelCenterL, BorderLayout.SOUTH);
            
          panelCenterL.add(testButton);
          panelCenterL.add(btnExit); 
        // Button 
        testButton.addActionListener(this);
        btnExit.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1120, 680);
        this.setVisible(true);
    }

    public void populateOverdueBooks() {
        LibraryClient.sendToServer("view overdue books");
        list = LibraryClient.readOverdueBooksFromServer();
        overdueBooks.setModel(model);
        model = (DefaultTableModel) overdueBooks.getModel();
        model.setRowCount(0);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) { 
            String ISBN = list.get(i).getISBN();  
            int daysOverdue = list.get(i).getDaysOverdue();
            double totalPenaltyCost = list.get(i).getTotalPenaltyCost();

            Object[] loanList = { 
                            ISBN, 
                            daysOverdue,
                            totalPenaltyCost
            };
            model.addRow(loanList);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == testButton) {
            populateOverdueBooks();
        }
        
        else if (e.getSource() == btnExit) {
            dispose();
        }

    }

    public static void main(String[] args) {
        new ViewOverdueBookGUI().setGUI();
    }
}
