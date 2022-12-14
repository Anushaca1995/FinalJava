package com.nology.finalApi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.time.LocalDate;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String full_Name;
    private String email_id;
    private String pwd;
    private String address;
    private String postcode;
    private LocalDate dateCreated = LocalDate.now();
    private Timestamp book_date;
    private boolean isComplete;
    private boolean isAdmin;

    public User() {
    }

    public User(Long id, String full_Name, String email_id, String pwd, String address, String postcode, LocalDate dateCreated, Timestamp book_date, boolean isAdmin, boolean isComplete) {
        this.id = id;
        this.full_Name = full_Name;
        this.email_id = email_id;
        this.pwd = pwd;
        this.address = address;
        this.postcode = postcode;
        this.dateCreated = dateCreated;
        this.book_date = book_date;
        this.isComplete = isComplete;
        this.isAdmin = isAdmin;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }

    public String getFull_Name() {
        return full_Name;
    }

    public void setFull_Name(String full_Name) {
        this.full_Name = full_Name;
    }


    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Timestamp getBook_date() {
        return book_date;
    }

    public void setBook_date(Timestamp book_date) {
        this.book_date = book_date;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

}
