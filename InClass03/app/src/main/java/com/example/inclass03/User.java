package com.example.inclass03;

import java.io.Serializable;

public class User implements Serializable {
    String gender;
    String fname;
    String lname;

    public User(String gender, String fname, String lname) {
        this.gender = gender;
        this.fname = fname;
        this.lname = lname;
    }

    @Override
    public String toString() {
        return "User{" +
                "gender='" + gender + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGender() {
        return gender;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }
}

