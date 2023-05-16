/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author User
 */
public class Loan implements Serializable {
    private String loanID;
    private String ISBN;
    private String learnerCode;
    private String dateIssued;
    private String dateDue;
    private int daysOverdue;
    private double totalPenaltyCost;

    public Loan() {
    }

    public Loan(String loanID) {
        this.loanID = loanID;
    }
    
    public Loan(String ISBN, int daysOverdue, double totalPenaltyCost) {
        this.ISBN = ISBN;
        this.daysOverdue = daysOverdue;
        this.totalPenaltyCost = totalPenaltyCost;
    }

       

    public Loan(String loanID, String ISBN, String learnerCode, String dateIssued, String dateDue, int daysOverdue, int totalPenaltyCost) {
        this.loanID = loanID;
        this.ISBN = ISBN;
        this.learnerCode = learnerCode;
        this.dateIssued = dateIssued;
        this.dateDue = dateDue;
        this.daysOverdue = daysOverdue;
        this.totalPenaltyCost = totalPenaltyCost;
    }
    
    public String getLoanID() {
        return loanID;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getLearnerCode() {
        return learnerCode;
    }

    public String getDateIssued() {
        return dateIssued;
    }

    public String getDateDue() {
        return dateDue;
    }

    public int getDaysOverdue() {
        return daysOverdue;
    }

    public double getTotalPenaltyCost() {
        return totalPenaltyCost;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setLearnerCode(String learnerCode) {
        this.learnerCode = learnerCode;
    }

    public void setDateIssued(String dateIssued) {
        this.dateIssued = dateIssued;
    }

    public void setDateDue(String dateDue) {
        this.dateDue = dateDue;
    }

    public void setDaysOverdue(int daysOverdue) {
        this.daysOverdue = daysOverdue;
    }
    
    public void setTotalPenaltyCost(double totalPenaltyCost) {
        this.totalPenaltyCost = totalPenaltyCost;
    }

    @Override
    public String toString() {
        return "Loan{" + "loanID=" + loanID + ", ISBN=" + ISBN + ", learnerCode=" + learnerCode + ", dateIssued=" + dateIssued + ", dateDue=" + dateDue + ", daysOverdue=" + daysOverdue + ", totalPenaltyCost=" + totalPenaltyCost + '}';
    }
  
}