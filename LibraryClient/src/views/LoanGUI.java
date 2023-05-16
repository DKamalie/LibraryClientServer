/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import domain.Loan;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import libraryclientupdate.LibraryClient;

/**
 *
 * @author User
 */
public class LoanGUI extends JFrame implements ActionListener {

    private ArrayList<Loan> list = new ArrayList<>();
//        Object rows[][] = {{"1234", "Keenan Meyer", "Jail breakers", "Horror", "145ab", "True"}};
//        String colums[] = {"ISBN", "Author", "Title", "Category", "Shelf Number", "Availible for loan"};

    DefaultTableModel model;

    private JLabel lblISBN;
    private JLabel lblHEADING;
    private JLabel lblAuthor;
    private JLabel lblshelfNumber;
    private JLabel lblTitle, lblGenre, lblAvaible, p4;

    private JTextField txtISBN;
    private JTextField txtAuthor;
    private JTextField txtTitle;
    private JTextField txtGenre;
    private JTextField txtshelfNumber;

    private JButton btnBorrowBook;
    private JButton btnUpdateTbl;
    private JButton btnBack;
    private JButton btnOverdueBooks;

    private JRadioButton btnYes;
    private JRadioButton btnNo;
    private ButtonGroup btnGroup;

    private JScrollPane pane;
    Font textFont = new Font("Courier", Font.BOLD, 30);
    Font textFont2 = new Font("Courier", Font.BOLD, 15);
    Color textColor = new Color(246, 255, 248);

    private JPanel panelTop, panelCenterL, panelCenterR, mainframe, test;

    private JTable students;

    public LoanGUI() {
        super("Show Book");

        panelTop = new JPanel();
        panelTop.setBackground(Color.red);

        mainframe = new JPanel();
        mainframe.setBackground(Color.BLACK);

        panelCenterL = new JPanel();
//     panelCenterL.setBackground(Color.blue);

        panelCenterR = new JPanel();
        panelCenterR.setBackground(Color.YELLOW);

        test = new JPanel();

        lblHEADING = new JLabel("Loan");
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

        txtISBN = new JTextField();
        txtAuthor = new JTextField();
        txtTitle = new JTextField();
        txtGenre = new JTextField();
        txtshelfNumber = new JTextField();

        btnBorrowBook = new JButton("View Loans");
        btnOverdueBooks = new JButton("View Overdue Books");
        btnUpdateTbl = new JButton("Update Table");
        btnBack = new JButton("Back");

        btnYes = new JRadioButton("Yes");
        btnNo = new JRadioButton("No");

        btnGroup = new ButtonGroup();
        btnGroup.add(btnYes);
        btnGroup.add(btnNo);

        //table
        model = new DefaultTableModel();
        students = new JTable(model);

        pane = new JScrollPane(students, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public void setGUI() {
        model.addColumn("LoanID");
        model.addColumn("ISBN");
        model.addColumn("LearnerCode");
        model.addColumn("dateIssued");
        model.addColumn("dateDue");
        model.addColumn("daysOverdue");
        model.addColumn("totalPenaltyCost");
        //TOP
        panelTop.setLayout(new GridLayout(1, 1));
        panelTop.add(lblHEADING);

        //mainframe
        mainframe.setBorder(new TitledBorder("MAIN"));
        mainframe.setLayout(new GridLayout(1, 2));
        mainframe.add(panelCenterL);
        mainframe.add(panelCenterR);
//
        panelCenterL.setLayout(null);
//
//        //LBLS AND TXTFIELDS
//        panelCenterL.add(lblISBN);
//        lblISBN.setBounds(100, 150, 200, 30);
//        panelCenterL.add(txtISBN);
//        txtISBN.setBounds(300, 150, 200, 30);
//
//        panelCenterL.add(lblAuthor);
//        lblAuthor.setBounds(100, 200, 200, 30);
//        panelCenterL.add(txtAuthor);
//        txtAuthor.setBounds(300, 200, 200, 30);
//
//        panelCenterL.add(lblTitle);
//        lblTitle.setBounds(100, 250, 200, 30);
//        panelCenterL.add(txtTitle);
//        txtTitle.setBounds(300, 250, 200, 30);
//
//        panelCenterL.add(lblGenre);
//        lblGenre.setBounds(100, 300, 200, 30);
//        panelCenterL.add(txtGenre);
//        txtGenre.setBounds(300, 300, 200, 30);
//
//        panelCenterL.add(lblshelfNumber);
//        lblshelfNumber.setBounds(100, 350, 200, 30);
//        panelCenterL.add(txtshelfNumber);
//        txtshelfNumber.setBounds(300, 350, 200, 30);
//
//        panelCenterL.add(lblAvaible);
//        lblAvaible.setBounds(100, 400, 350, 30);
////        panelCenterL.add(txtAvaible); 
////        txtAvaible.setBounds(200, 350, 200, 30);

        //BUTTONS
        panelCenterL.add(btnBorrowBook);
        btnBorrowBook.setBounds(100, 450, 100, 30);
        btnBorrowBook.setBorder(new RoundedBorder(23));
        btnBorrowBook.setBorder(BorderFactory.createLineBorder(textColor, 1, true));
        
        panelCenterL.add(btnOverdueBooks);
        btnOverdueBooks.setBounds(100, 300, 200, 30);; 
        btnOverdueBooks.setBorder(BorderFactory.createLineBorder(textColor, 1, true));

        panelCenterL.add(btnUpdateTbl);
        btnUpdateTbl.setBounds(220, 450, 100, 30);
        btnUpdateTbl.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));

        panelCenterL.add(btnBack);
        btnBack.setBounds(340, 450, 100, 30);
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));
        //left to right pos,up and down pos, 

//        panelCenterL.add(btnNo);
//        btnNo.setBounds(420, 400, 50, 20);
//
//        panelCenterL.add(btnYes);
//        btnYes.setBounds(350, 400, 50, 20);
        //RIGHT PANEL
        panelCenterR.setLayout(new BorderLayout());

        panelCenterR.add(pane, BorderLayout.CENTER);

        btnBorrowBook.addActionListener(this);
        btnUpdateTbl.addActionListener(this);
        btnBack.addActionListener(this);
        btnOverdueBooks.addActionListener(this);

        btnYes.addActionListener(this);
        btnNo.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(panelTop, BorderLayout.NORTH);
        this.add(mainframe);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1120, 680);
        this.setVisible(true);
    }

    public boolean isAvailable() {
        boolean a = true;

        if (btnGroup.isSelected(btnYes.getModel())) {
            a = true;
        } else if (btnGroup.isSelected(btnNo.getModel())) {
            a = false;
        }
        return a;
    }

    public void populateLoan() {
        LibraryClient.sendToServer("view loans");
        list = LibraryClient.readLoanFromServer();
        students.setModel(model);
        model = (DefaultTableModel) students.getModel();
        model.setRowCount(0);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            String loanID = list.get(i).getLoanID();
            String ISBN = list.get(i).getISBN();
            String learnerCode = list.get(i).getLearnerCode();
            String dateIssued = list.get(i).getDateIssued();
            String dateDue = list.get(i).getDateDue();
            int daysOverdue = list.get(i).getDaysOverdue();
            double totalPenaltyCost = list.get(i).getTotalPenaltyCost();

            Object[] loanList = {
                loanID,
                ISBN,
                learnerCode,
                dateIssued,
                dateDue,
                daysOverdue,
                totalPenaltyCost
            };
            model.addRow(loanList);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String avail;
        if (isAvailable() == true) {
            avail = "true";
        } else {
            avail = "false";
        }

        String ISBN = txtISBN.getText();
        String Author = txtAuthor.getText();
        String Title = txtTitle.getText();
        String Genre = txtGenre.getText();
        String shelfNumber = txtshelfNumber.getText();

        if (e.getSource() == btnBorrowBook) {

        } else if (e.getSource() == btnUpdateTbl) {
            populateLoan();

        }else if (e.getSource() == btnOverdueBooks) {
            ViewOverdueBookGUI k = new ViewOverdueBookGUI();
            k.setGUI();
            //dispose();

        }
        else if (e.getSource() == btnBack) {
            HomeGUI k = new HomeGUI();
            k.setGUI();
            dispose();
        }
    }

}
