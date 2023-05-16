package dao;

import domain.Learner;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Brandon
 */
public class LearnerDAO {

    private static final String DATABASE_URL = "jdbc:derby://localhost:1527/LibraryDB";
    private static final String USERNAME = "administrator";
    private static final String PASSWORD = "password";

    // Instance Variables 
    private String learnerCode, name, surname, grade, canBorrow;

    public LearnerDAO(String learnerCode, String name, String surname, String grade, String canBorrow) {
        this.learnerCode = learnerCode;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.canBorrow = canBorrow;
    }

    public static boolean addLearner(Learner learner) {
        Connection connection = null;
        Statement statement = null;
        int ok;
        boolean success = true;

        try {
            try {
                connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
                statement = connection.createStatement();

                ok = statement.executeUpdate("INSERT INTO Learner VALUES('" + learner.getLearnerCode() + "', '" + learner.getName() + "', '" + learner.getSurname() + "', '" + learner.getGrade() + "', '" + learner.getCanBorrow() + "')");

                if (ok > 0) {
                    JOptionPane.showMessageDialog(null, "Succes! The learner has been added.");
                    success = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Error: The learner could not be added.");
                    success = false;
                }
            } catch (HeadlessException | SQLException uniqueException) {
                JOptionPane.showMessageDialog(null, "The learner code is not unique");
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

    public static boolean updateLearner(Learner l) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean success = true;
        int ok;

        String update = "UPDATE Learner "
                + "SET CanBorrow = 'true' WHERE LearnerCode = ?";
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            ps = connection.prepareStatement(update);
            ps.setString(1, l.getLearnerCode());

            ok = ps.executeUpdate();
            if (ok > 0) {
                JOptionPane.showMessageDialog(null, "Learner has been successfully updated");
            } else {
                JOptionPane.showMessageDialog(null, "Could not update learner");
                success = false;
            }

        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, sqlException);
            success = false;
        }
        return success;
    }

    public static ArrayList<String> populateComboLearnerCode() {
        Connection connection = null;
        Statement statement = null;

        ArrayList<String> learnerID = new ArrayList<>();

        String qry = "SELECT * FROM Learner";

        try {
            connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(qry);

            if (rs != null) {
                while (rs.next()) {
                    learnerID.add(rs.getString(1));
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
        return learnerID;
    }

}
