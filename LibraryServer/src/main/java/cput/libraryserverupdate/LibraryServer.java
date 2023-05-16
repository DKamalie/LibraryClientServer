/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cput.libraryserverupdate;

import dao.BookDAO;
import dao.LearnerDAO;
import dao.LoanDAO;
import domain.Book;
import domain.Learner;
import domain.Loan;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LibraryServer {

    // Instance variables
    static ServerSocket s;
    static Socket s1;
    static ObjectInputStream input;
    static ObjectOutputStream output;

    public static void main(String[] args) {
        getConnection();
        listenForClient();
        getStreams();
        processClient();
    }

    public static void getConnection() {
        try {
            s = new ServerSocket(1233);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Running...");

    }

    public static void listenForClient() {
        try {
            s1 = s.accept();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Listening...");
    }

    public static void getStreams() {
        try {

            output = new ObjectOutputStream(s1.getOutputStream());
            input = new ObjectInputStream(s1.getInputStream());
            output.flush();
            System.out.println("Reached FLUSH or something");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            s1.close();
            input.close();
            output.close();
            JOptionPane.showMessageDialog(null, "Server Connection Closed");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    public static void processClient() {
        System.out.println("1");
        try {
            String msg;

            System.out.println("4");
            do {
                System.out.println("2");

                System.out.println("3");
                Book book1;
                Learner learner1;
                Loan loan1;
                System.out.println("5");
                msg = (String) input.readObject();
                System.out.println("6");

                if (msg.equals("add book")) {
                    System.out.println("7");
                    book1 = (Book) input.readObject();
                    System.out.println("8");
                    BookDAO.addBook(book1);
                    System.out.println("9");
                } else if (msg.equals("return book")) {
                    System.out.println("7");
                    book1 = (Book) input.readObject();
                    System.out.println("");
                    BookDAO.returnBook(book1);

                    System.out.println("return Book done");
                } else if (msg.equals("add Learner")) {
                    System.out.println("7");
                    learner1 = (Learner) input.readObject();
                    System.out.println("8");
                    LearnerDAO.addLearner(learner1);

                    System.out.println("9");
                } else if (msg.equals("view all books")) {
                    System.out.println("7");
//                    learner1 = (Learner) input.readObject();
//                    System.out.println("8");
//                    LearnerDAO.addLearner(learner1);
                    System.out.println("9");
                } else if (msg.equals("view loans")) {
                    System.out.println("view loans called");
                    ArrayList<Loan> listLoan = LoanDAO.printLoan();
                    output.writeObject(listLoan);
                    System.out.println(listLoan);
                    System.out.println("After Loans called");
                } else if (msg.equals("view overdue books")) {
                    System.out.println("view Books called");
                    ArrayList<Loan> listOverdueBooks = LoanDAO.viewOverdueBooks();
                    output.writeObject(listOverdueBooks);
                    System.out.println(listOverdueBooks);
                    System.out.println("After Books called");
                    ///worked from
                     
                } else if (msg.equals("populate Combo Learner Code + ISBN")) {
                    System.out.println("view Combo Learner code called");
                    ArrayList<String> listComboLearnerCode = LearnerDAO.populateComboLearnerCode();//CALLED AS STRING
                    output.writeObject(listComboLearnerCode);
                    System.out.println(listComboLearnerCode);
                    System.out.println("After view Combo Learner code");
                    //isbn called
                    System.out.println("view Combo ISNBN called");
                    ArrayList<String> listBookISBN = BookDAO.populateComboISBN(); //CALLED AS STRING
                    output.writeObject(listBookISBN);
                    System.out.println(listBookISBN);
                    System.out.println("After Combo ISNBN called");
                }
                else if (msg.equals("populate Combo ISBN")) {

                }

            } while (!msg.equals("close"));
            System.out.println("10");
            closeConnection();
            System.out.println("11");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error: " + cnfe.getMessage());
        }
    }
}
