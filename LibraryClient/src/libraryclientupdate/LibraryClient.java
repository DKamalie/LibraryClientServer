/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryclientupdate;

import domain.Book;
import domain.Learner;
import domain.Loan;
import java.net.*;
import java.io.*;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.ArrayList;
import java.util.Iterator;
import views.BookGUI;
import views.HomeGUI;

/**
 *
 * @author User
 */
public class LibraryClient {
    // Instance variables
    static Socket s1;
    static InputStream in;
    static OutputStream out;
    static ObjectInputStream input;
    static ObjectOutputStream output;
   
    /**
     * @param args the command line arguments
     */
    
    
    public static void makeConnection() { 
        try { 
            System.out.println("Reached make connection");
            s1 = new Socket("localhost", 1233);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Reached make connection");
        System.out.println("Connection established at port: " + "1233");
    }
 

    public static void getStreams() {
        try {
            System.out.println("Before Output");
            output = new ObjectOutputStream(s1.getOutputStream());
            System.out.println("Before input");
            input = new ObjectInputStream(s1.getInputStream());
            System.out.println("After both");
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
             
        }
    }

    public static void sendToServer(Object object) {

        try {
            output.writeObject(object);
            output.flush();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Reached send to server");
    }

    public static ArrayList<Loan> readLoanFromServer() {
        ArrayList<Loan> tata = null;
        try {
            tata = (ArrayList<Loan>) input.readObject();
            System.out.println("Reached read Loan from server");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return tata;
    } 
    
    public static ArrayList<Loan> readOverdueBooksFromServer() {
        ArrayList<Loan> overdue = null;
        try {
            overdue = (ArrayList<Loan>) input.readObject();
            System.out.println("Reached read Loan from server");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return overdue;
    }
    
    public static ArrayList<Book>  readBookFromServer() {
        ArrayList<Book> booked = null;
        try {
            booked = (ArrayList<Book>) input.readObject();
            System.out.println("Reached read Book from server");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return booked;
    } 
    
    public static ArrayList<String> readComboISBNFromServer() {
        ArrayList<String> boxISBN = null;
        try {
            boxISBN = (ArrayList<String>) input.readObject();
            System.out.println("Reached read Combo ISBN from server");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return boxISBN;
    }

    public static ArrayList<String> readComboLearnerIDFromServer() {
        ArrayList<String> boxLearnerID = null;
        try {
            boxLearnerID = (ArrayList<String>) input.readObject();
            System.out.println("Reached read Combo Learner from server");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return boxLearnerID;
    }
    
    
    public static void closeConnection() {

        try {
            System.out.println("Reached closed connection");
            s1.close();
            input.close();
            output.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("Connection closed");
    }
    

}
