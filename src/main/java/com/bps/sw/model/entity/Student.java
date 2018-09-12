package com.bps.sw.model.entity;

/**
 * Created by Moazen on 9/9/2018.
 */
public class Student {
    String firstName;
    String lastName;
    String studentNumber;
    String nationalCode;

    public Student(String firstName, String lastName, String studentNumber, String nationalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        this.nationalCode = nationalCode;
    }

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getNationalCode() {
        return nationalCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public void setNationalCode(String nationalCode) {
        this.nationalCode = nationalCode;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", nationalCode='" + nationalCode + '\'' +
                '}';
    }
}
