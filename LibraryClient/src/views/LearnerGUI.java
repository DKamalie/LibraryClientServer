/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import domain.Book;
import domain.Learner;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import libraryclientupdate.LibraryClient;

/**
 *
 * @author User
 */
public class LearnerGUI extends JFrame implements ActionListener {

    private ArrayList<Book> list = null;

    private JLabel lblLearnerCode;
    private JLabel lblHEADING;
    private JLabel lblName;
    private JLabel lblSurname;
    private JLabel lblGrade, lblCanBorrow;
    private JLabel lblAvaible, p4;

    private JTextField txtLearnerCode;
    private JTextField txtName;
    private JTextField txtSurname;
    private JTextField txtGrade;
    private JTextField txtCanBorrow;

//    private JPasswordField passwordInput;
    private JButton btnAdd;
    private JButton btnDelete;
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

    public LearnerGUI() {
        super("Learner");
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

        lblHEADING = new JLabel("Add Learner");
        lblHEADING.setFont(textFont);
        
        lblLearnerCode = new JLabel("Learner Code");
        lblLearnerCode.setFont(textFont2);

        lblName = new JLabel("Name");
        lblName.setFont(textFont2);

        lblSurname = new JLabel("Surname");
        lblSurname.setFont(textFont2);

        lblGrade = new JLabel("Grade");
        lblGrade.setFont(textFont2);

        lblCanBorrow = new JLabel("CanBorrow: ");
        lblCanBorrow.setFont(textFont2);

//        lblshelfNumber = new JLabel("Shelf Number: ");
//        lblshelfNumber.setFont(textFont2);

        txtLearnerCode = new JTextField();
        txtName = new JTextField();
        txtSurname = new JTextField();
        txtGrade = new JTextField();
        txtCanBorrow = new JTextField();
//     txtAvaible = new TextField();

        btnAdd = new JButton("Add Learner");
        btnDelete = new JButton("Delete");
        btnBack = new JButton("Back");

        btnYes = new JRadioButton("Yes");
        btnNo = new JRadioButton("No");

        btnGroup = new ButtonGroup();
        btnGroup.add(btnYes);
        btnGroup.add(btnNo);

        //table
        Object rows[][] = {{"1234", "Keenan Meyer", "Jail breakers", "Horror", "145ab", "True"}};
        String colums[] = {"ISBN", "Author", "Title", "Category", "Shelf Number", "Availible for loan"};

        TableModel model;
        model = new DefaultTableModel(rows, colums);
        students = new JTable(model);

        pane = new JScrollPane(students, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    }

    public LearnerGUI(ArrayList<Book> list) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setGUI() {
        //TOP
        panelTop.setLayout(new GridLayout(1, 1));
        panelTop.add(lblHEADING);

        //mainframe
//        mainframe.setBorder(new TitledBorder("MAIN"));
        mainframe.setLayout(new GridLayout(1, 1));
        mainframe.add(panelCenterL);
//        mainframe.add(panelCenterR);

        panelCenterL.setLayout(null);



        //LBLS AND TXTFIELDS
        panelCenterL.add(lblLearnerCode);
        lblLearnerCode.setBounds(100, 150, 200, 30);
        panelCenterL.add(txtLearnerCode);
        txtLearnerCode.setBounds(300, 150, 200, 30);

        panelCenterL.add(lblName);
        lblName.setBounds(100, 200, 200, 30);
        panelCenterL.add(txtName);
        txtName.setBounds(300, 200, 200, 30);

        panelCenterL.add(lblSurname);
        lblSurname.setBounds(100, 250, 200, 30);
        panelCenterL.add(txtSurname);
        txtSurname.setBounds(300, 250, 200, 30);

        panelCenterL.add(lblGrade);
        lblGrade.setBounds(100, 300, 200, 30);
        panelCenterL.add(txtGrade);
        txtGrade.setBounds(300, 300, 200, 30);

//        panelCenterL.add(lblCanBorrow);
//        lblCanBorrow.setBounds(100, 350, 200, 30);
//        panelCenterL.add(txtCanBorrow);
//        txtCanBorrow.setBounds(300, 350, 200, 30);
//
//        panelCenterL.add(lblAvaible);
//        lblAvaible.setBounds(100, 400, 350, 30);

        //BUTTONS
        panelCenterL.add(btnAdd);
        btnAdd.setBounds(130, 360, 100, 30);
        btnAdd.setBorder(new RoundedBorder(23));
        btnAdd.setBorder(BorderFactory.createLineBorder(textColor, 1, true));

//        panelCenterL.add(btnDelete);
        btnDelete.setBounds(220, 360, 100, 30);
        btnDelete.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));

        panelCenterL.add(btnBack);
        btnBack.setBounds(340, 360, 100, 30);
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));
        //left to right pos,up and down pos, 

//        panelCenterL.add(btnNo);
//        btnNo.setBounds(420, 350, 50, 20);
//
//        panelCenterL.add(btnYes);
//        btnYes.setBounds(350, 350, 50, 20);

        //RIGHT PANEL
        panelCenterR.setLayout(new BorderLayout());

        panelCenterR.add(pane, BorderLayout.CENTER);

        btnAdd.addActionListener(this);
        btnDelete.addActionListener(this);
        btnBack.addActionListener(this);

        btnYes.addActionListener(this);
        btnNo.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(panelTop, BorderLayout.NORTH);
        this.add(mainframe);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(620, 680);
        this.setLocationRelativeTo(null);
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

    @Override
    public void actionPerformed(ActionEvent e) {
        String avail;

        if (isAvailable() == true) {
            avail = "true";
        } else {
            avail = "false";
        }

        String learnerCode = txtLearnerCode.getText();
        String name = txtName.getText();
        String surname = txtSurname.getText();
        String grade = txtGrade.getText();

        if (e.getSource() == btnAdd) {
            isAvailable();
            Learner h = new Learner(
                    learnerCode,
                    name,
                    surname,
                    grade,
                    avail
            );

            LibraryClient.sendToServer("add Learner");
            LibraryClient.sendToServer(h);
            System.out.println(h.toString());
        } else if (e.getSource() == btnDelete) {
            isAvailable();
        } else if (e.getSource() == btnBack) {
            HomeGUI g = new HomeGUI();
            g.setGUI();
            dispose();
            }
        }
    public static void main(String[] args) {
        LearnerGUI g = new LearnerGUI();
        g.setGUI();
    }
}

