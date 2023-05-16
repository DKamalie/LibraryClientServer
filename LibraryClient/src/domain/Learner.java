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
public class Learner implements Serializable {
    // Instance variables
    private String learnerCode;
    private String name;
    private String surname;
    private String grade;
    private String canBorrow;

    public Learner() {
    }

    public Learner(String learnerCode) {
        this.learnerCode = learnerCode;
    }

    public Learner(String learnerCode, String name, String surname, String grade, String canBorrow) {
        this.learnerCode = learnerCode;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.canBorrow = canBorrow;
    }

    public String getLearnerCode() {
        return learnerCode;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGrade() {
        return grade;
    }

    public String getCanBorrow() {
        return canBorrow;
    }

    public void setLearnerCode(String learnerCode) {
        this.learnerCode = learnerCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCanBorrow(String canBorrow) {
        this.canBorrow = canBorrow;
    }

    @Override
    public String toString() {
        return "Learner{" + "learnerCode=" + learnerCode + ", name=" + name + ", surname=" + surname + ", grade=" + grade + ", canBorrow=" + canBorrow + '}';
    }
}
