package dao;

import domain.Loan;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class LoanDAO {

    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/LibraryDB";
    private static final String USERNAME = "administrator";
    private static final String PASSWORD = "password";

    // Instance Variables
    private String loanID, ISBN, learnerCode, dateIssued, dateDue, daysOverdue;
    private Double totalPenaltyCost;

    public static boolean addLoan(Loan loan) {
        Connection connection = null;
        Statement statement = null;
        int ok;
        boolean success = true;

        try {
            try {
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                statement = connection.createStatement();

                ok = statement.executeUpdate("INSERT INTO Loan VALUES('" + loan.getLoanID() + "', '" + loan.getISBN() + "', '" + loan.getLearnerCode() + "', '" + loan.getDateIssued() + "', '" + loan.getDateDue() + "', '" + loan.getDaysOverdue() + "', '" + loan.getTotalPenaltyCost() + "')");

                if (ok > 0) {
                    JOptionPane.showMessageDialog(null, "Succes! The loan has been added.");
                    success = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: The loan could not be added.");
                    success = false;
                }
            } catch (HeadlessException | SQLException uniqueException) {
                JOptionPane.showMessageDialog(null, "The loan ID is not unique");
            }
        } catch (HeadlessException sqlException) {
            JOptionPane.showMessageDialog(null, "Error: The details could not be added." + sqlException);
            success = false;
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
                success = false;
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException exception) {
                JOptionPane.showMessageDialog(null, exception.getMessage(), "Warning", JOptionPane.ERROR_MESSAGE);
                success = false;
            }
        }
        return success;
    }

    public static ArrayList<Loan> printLoan() {
        Connection connection = null;
        Statement statement = null;
        ArrayList<Loan> list = new ArrayList<>();
        String sql = "SELECT * FROM LOAN";

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs != null) {
                while (rs.next()) {
                    list.add(new Loan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
                }
            }
        } catch (SQLException sqlE) {
            JOptionPane.showMessageDialog(null, "Error: Could not read from Database. " + sqlE);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning", JOptionPane.ERROR);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning", JOptionPane.ERROR);
            }
        }
        return list;

    }

    public static ArrayList<Loan> viewOverdueBooks() { 
        ArrayList<Loan> viewLoans = new ArrayList<Loan>();
        Connection connection = null;
        PreparedStatement statement = null;
        String sql = "SELECT ISBN, DaysOverdue, TotalPenaltyCost FROM LOAN";
        ResultSet rs = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.prepareStatement(sql);
            rs = statement.executeQuery();

            while (rs.next()) {
                Loan loan = new Loan(
                        rs.getString(1),
                        rs.getInt(2),
                        rs.getDouble(3));
                viewLoans.add(loan);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                System.out.println("Error: " + e);
            }
        }
        return viewLoans;
    }
}


