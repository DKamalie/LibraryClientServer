/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Book;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class BookDAO {

    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/LibraryDB";
    private static final String USERNAME = "administrator";
    private static final String PASSWORD = "password";

    // Instance Variables 
    private String ISBN, bookAuthor, bookTitle, bookCategory, shelfNumber, available;

    public BookDAO(String ISBN, String bookAuthor, String bookTitle, String bookCategory, String shelfNumber, String available) {
        this.ISBN = ISBN;
        this.bookAuthor = bookAuthor;
        this.bookTitle = bookTitle;
        this.bookCategory = bookCategory;
        this.shelfNumber = shelfNumber;
        this.available = available;
    }
    
    public static boolean returnBook(Book m) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean success = true;
        int ok;

        String update = "UPDATE Book "
                + "SET AVAILABLEFORLOAN = 'true' WHERE ISBN = ?";
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            ps = connection.prepareStatement(update);
            ps.setString(1, m.getISBN());
            
            ok = ps.executeUpdate();
            if (ok>0){
                JOptionPane.showMessageDialog(null, "Book has been returned");
            } else {
                JOptionPane.showMessageDialog(null, "Book could not be returned");
                success = false;
            }

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException);
            success = false;
        }
        return success;
    }

    public static ArrayList<Book> getAllBooks() {
        ArrayList<Book> list = new ArrayList<Book>();
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "SELECT * FROM BOOK";
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                Book book = new Book(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6));
                list.add(book);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                System.out.println("Error: " + e);
            }
        }
        return list;
    }

    public BookDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        

    

    public static boolean addBook(Book book) {
        Connection connection = null;
        Statement statement = null;
        int ok;
        boolean success = true;

        try {
            try {
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                statement = connection.createStatement();
                
                ok = statement.executeUpdate("INSERT INTO Book VALUES('" + book.getISBN() + "', '" + book.getBookAuthor() + "', '" + book.getBookTitle() + "', '" + book.getBookCategory() + "', '" + book.getShelfNumber() + "', '" + book.getAvailable() + "')");

                if (ok > 0) {
                    JOptionPane.showMessageDialog(null, "Succes! Your details have been added.");
                    success = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: Your details could not be added.");
                    success = false;
                }
            } catch (Exception uniqueException) {
                JOptionPane.showMessageDialog(null, "The ISBN code is not unique");
            }
        } catch (Exception sqlException) {
            JOptionPane.showMessageDialog(null, "Error: Your details could not be added." + sqlException);
            success = false;
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
                success = false;
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
                success = false;
            }
        }
        return success;
    }
    
    public static ArrayList<String> populateComboISBN() {
        Connection connection = null;
        Statement statement = null;

        ArrayList<String> bookISBN = new ArrayList<>();

        String qry = "SELECT * FROM BOOK";

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(qry);

            if (rs != null) {
                while (rs.next()) {
                    bookISBN.add(rs.getString(1));
                }
            }

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException statementException) {
                JOptionPane.showMessageDialog(null, "The following error occurred: " + statementException, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException connectionException) {
                JOptionPane.showMessageDialog(null, "The following error occurred: " + connectionException, "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        }
        return bookISBN;
    }


}


