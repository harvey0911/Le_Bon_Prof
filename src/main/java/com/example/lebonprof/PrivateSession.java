package com.example.lebonprof;

import java.time.LocalDate;

public class PrivateSession {


Person student;
Person professor;
LocalDate date;
Subject subject;

Boolean student_attendance;
Boolean professor_attendance;

int salle;

    public PrivateSession() {
    }

    public PrivateSession(Person student, Person professor, LocalDate date,int salle,Subject subject) {
        this.student = student;
        this.professor = professor;
        this.date = date;
        this.salle=salle;
        this.subject=subject;
    }


    public Person getStudent() {
        return student;
    }

    public void setStudent(Person student) {
        this.student = student;
    }

    public Person getProfessor() {
        return professor;
    }

    public void setProfessor(Person professor) {
        this.professor = professor;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Boolean getStudent_attendance() {
        return student_attendance;
    }

    public void setStudent_attendance(Boolean student_attendance) {
        this.student_attendance = student_attendance;
    }

    public Boolean getProfessor_attendance() {
        return professor_attendance;
    }

    public void setProfessor_attendance(Boolean professor_attendance) {
        this.professor_attendance = professor_attendance;
    }

    public int getSalle() {
        return salle;
    }

    public void setSalle(int salle) {
        this.salle = salle;
    }

    @Override
    public String toString() {
        return "Private Session Details:\n"
                + "com.example.lebonprof.Student: " + student.getFirst_name()+ "\n"
                + "Prof: " + professor.getFirst_name()+ "\n"
                + "matière: " + subject.getSubject()+ "\n"
                + "Date: " + date + "\n"
                + "Salle: " + salle +"\n"
                +"----------------------------------------------------------------------\n"
        ;
    }


}
