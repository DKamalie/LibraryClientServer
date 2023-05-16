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
public class BookGUI extends JFrame implements ActionListener {

    DefaultTableModel model;
    private ArrayList<Book> list = null;

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

//    private JPasswordField passwordInput;
    private JButton btnAdd;
    private JButton btnDelete;
    private JButton btnReturn;
    private JButton btnViewOverdueBooks;
    private JButton btnBack;

    private JRadioButton btnYes;
    private JRadioButton btnNo;
    private ButtonGroup btnGroup;

    private JScrollPane pane;
    Font textFont = new Font("Courier", Font.BOLD, 30);
    Font textFont2 = new Font("Courier", Font.BOLD, 15);
    Color textColor = new Color(246, 255, 248);

    private JPanel panelTop, panelCenterL, panelCenterR, mainframe, test;

    private JTable students;

    public BookGUI() {
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

        txtISBN = new JTextField();
        txtAuthor = new JTextField();
        txtTitle = new JTextField();
        txtGenre = new JTextField();
        txtshelfNumber = new JTextField();
//     txtAvaible = new TextField();

        btnAdd = new JButton("Add Book");
        btnDelete = new JButton("Delete");
        btnReturn = new JButton("Return Book");
        btnViewOverdueBooks = new JButton("View overdue books");
        btnBack = new JButton("Back");

        btnYes = new JRadioButton("Yes");
        btnNo = new JRadioButton("No");

        btnGroup = new ButtonGroup();
        btnGroup.add(btnYes);
        btnGroup.add(btnNo);

        //table
        TableModel model;
        model = new DefaultTableModel();
        students = new JTable(model);

        pane = new JScrollPane(students, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    

    public void setGUI() {
        //TOP
        panelTop.setLayout(new GridLayout(1, 1));
        panelTop.add(lblHEADING);

        //mainframe
        mainframe.setBorder(new TitledBorder("MAIN"));
        mainframe.setLayout(new GridLayout(1, 2));
        mainframe.add(panelCenterL);
        mainframe.add(panelCenterR);

        panelCenterL.setLayout(null);

        //BUTTONS
        panelCenterL.add(btnBack);
        btnBack.setBounds(220, 350, 100, 30);
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));

        panelCenterL.add(btnViewOverdueBooks);
        btnViewOverdueBooks.setBounds(180, 200, 180, 30);
        btnViewOverdueBooks.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));

        panelCenterL.add(btnAdd);
        btnAdd.setBounds(220, 250, 100, 30);
        btnAdd.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));

        panelCenterL.add(btnDelete);
        btnDelete.setBounds(220, 300, 100, 30);
        btnDelete.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));

        panelCenterL.add(btnReturn);
        btnReturn.setBounds(220, 150, 100, 30);
        btnReturn.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));
        //left to right pos,up and down pos, 

//        panelCenterL.add(btnNo);
//        btnNo.setBounds(420, 400, 50, 20);
//
//        panelCenterL.add(btnYes);
//        btnYes.setBounds(350, 400, 50, 20);
        //RIGHT PANEL
        panelCenterR.setLayout(new BorderLayout());

        panelCenterR.add(pane, BorderLayout.CENTER);

        btnBack.addActionListener(this);
        btnViewOverdueBooks.addActionListener(this);
        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnReturn.addActionListener(this);

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

    public void populateOverdueBooks() {
        LibraryClient.sendToServer("view Books Overdue");
        list = LibraryClient.readBookFromServer();
        students.setModel(model);
        model = (DefaultTableModel) students.getModel();
        model.setRowCount(0);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
//            String loanID = list.get(i).getLoanID();
//            String ISBN = list.get(i).getISBN();
//            String learnerCode = list.get(i).getLearnerCode();
//            String dateIssued = list.get(i).getDateIssued();
//            String dateDue = list.get(i).getDateDue();
//            int daysOverdue = list.get(i).getDaysOverdue();
//            double totalPenaltyCost = list.get(i).getTotalPenaltyCost();

            Object[] loanList = {
//                loanID,
//                ISBN,
//                learnerCode,
//                dateIssued,
//                dateDue,
//                daysOverdue,
//                totalPenaltyCost
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

        if (e.getSource() == btnAdd) {
//            isAvailable();
//            Book h = new Book(
//                    ISBN,
//                    Author,
//                    Title,
//                    Genre,
//                    shelfNumber,
//                    avail
//            );
//
//            LibraryClient.sendToServer("add book");
//            LibraryClient.sendToServer(h);
//            System.out.println(h.toString());
            AddBookGUI j = new AddBookGUI();
            j.setGUI();
            dispose();
        } else if (e.getSource() == btnViewOverdueBooks) {
            populateOverdueBooks();
        } else if (e.getSource() == btnDelete) {
            isAvailable();
        } else if (e.getSource() == btnReturn) {
            ReturnBookGUI g = new ReturnBookGUI();
            g.setGUI();
            dispose();
//            Book k = new Book(ISBN);
//
////            if (avail.equals("true")) {
////                JOptionPane.showMessageDialog(null, "Book already returned!");
////            } else {
//                LibraryClient.sendToServer("return book");
//                LibraryClient.sendToServer(k);
//                System.out.println(k.toString());
        } else if (e.getSource() == btnBack) {
            HomeGUI k = new HomeGUI();
            k.setGUI();
            dispose();
        }
    }

    public static void main(String[] args) {
        BookGUI h = new BookGUI();
        h.setGUI();

    }
}
