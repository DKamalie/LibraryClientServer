
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import libraryclientupdate.LibraryClient;

/**
 *
 * @author User
 */
public class ReturnBookGUI extends JFrame implements ActionListener {

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
    private JButton btnReturn;
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

    public ReturnBookGUI() {
        super("Return a Book");
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

        lblHEADING = new JLabel("Return a Book");
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

        btnReturn = new JButton("Return Book");
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

    public ReturnBookGUI(ArrayList<Book> list) {
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
        panelCenterL.add(lblISBN);
        lblISBN.setBounds(50, 150, 150, 30);
        panelCenterL.add(txtISBN);
        txtISBN.setBounds(150, 150, 150, 30);

//        //BUTTONS
        panelCenterL.add(btnReturn);
        btnReturn.setBounds(80, 220, 100, 30);
        btnReturn.setBorder(new RoundedBorder(23));
        btnReturn.setBorder(BorderFactory.createLineBorder(textColor, 1, true));

//        panelCenterL.add(btnDelete);
        btnDelete.setBounds(220, 450, 100, 30);
        btnDelete.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));
//
        panelCenterL.add(btnBack);
        btnBack.setBounds(200, 220, 100, 30);
        btnBack.setBorder(BorderFactory.createLineBorder(new Color(76, 201, 240), 1, true));
        //left to right pos,up and down pos, 


        //RIGHT PANEL
        panelCenterR.setLayout(new BorderLayout());

        panelCenterR.add(pane, BorderLayout.CENTER);

        btnReturn.addActionListener(this);
        btnDelete.addActionListener(this);
        btnBack.addActionListener(this);

        btnYes.addActionListener(this);
        btnNo.addActionListener(this);

        this.setLayout(new BorderLayout());
        this.add(panelTop, BorderLayout.NORTH);
        this.add(mainframe);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(420, 480);
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

        String ISBN = txtISBN.getText();
        String Author = txtAuthor.getText();
        String Title = txtTitle.getText();
        String Genre = txtGenre.getText();
        String shelfNumber = txtshelfNumber.getText();

        if (e.getSource() == btnReturn) {

             Book k = new Book(ISBN);

                LibraryClient.sendToServer("return book");
                LibraryClient.sendToServer(k);
                System.out.println(k.toString());

            LibraryClient.sendToServer("add book");
            LibraryClient.sendToServer(k);
            System.out.println(k.toString());
        } else if (e.getSource() == btnDelete) {
            isAvailable();
        } else if (e.getSource() == btnBack) {
            BookGUI g = new BookGUI();
            g.setGUI();
            dispose();
            
            }
        }
    public static void main(String[] args) {
        ReturnBookGUI g = new ReturnBookGUI();
        g.setGUI();
    }
}

