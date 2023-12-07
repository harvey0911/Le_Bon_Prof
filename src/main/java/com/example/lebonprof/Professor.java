package com.example.lebonprof;

import java.sql.Date;

public class Professor {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String contactNumber;
    private String Subject;

    public Professor(int id, String firstName, String lastName, String email, String contactNumber, String subject) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.contactNumber = contactNumber;
        Subject = subject;
    }
}
