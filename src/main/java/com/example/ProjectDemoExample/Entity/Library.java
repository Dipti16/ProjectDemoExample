package com.example.ProjectDemoExample.Entity;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lib_seq")
    @SequenceGenerator(name = "lib_seq")
    long id;
    String stuName;
    String email;
    String nameOfBook;
    String phoneNO;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date borrowDate;


    public Library() {
    }

    public Library(String stuName, String email, String nameOfBook, String phoneNO, Date borrowDate) {

        this.stuName = stuName;
        this.email = email;
        this.nameOfBook = nameOfBook;
        this.phoneNO = phoneNO;
        this.borrowDate = borrowDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public String getPhoneNO() {
        return phoneNO;
    }

    public void setPhoneNO(String phoneNO) {
        this.phoneNO = phoneNO;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;

    }



    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", email='" + email + '\'' +
                ", nameOfBook='" + nameOfBook + '\'' +
                ", phoneNO=" + phoneNO +
                ", borrowDate=" + borrowDate +
                '}';
    }
}