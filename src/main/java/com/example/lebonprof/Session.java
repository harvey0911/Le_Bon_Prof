package com.example.lebonprof;

public class Session {

    int session_id;
    int professor_id;
    int subject_id;
    int salle_id;


    public Session(int session_id, int professor_id, int subject_id, int salle_id) {
        this.session_id = session_id;
        this.professor_id = professor_id;
        this.subject_id = subject_id;
        this.salle_id = salle_id;
    }


    public int getSession_id() {
        return session_id;
    }

    public void setSession_id(int session_id) {
        this.session_id = session_id;
    }

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public int getSubject_id() {
        return subject_id;
    }

    public void setSubject_id(int subject_id) {
        this.subject_id = subject_id;
    }

    public int getSalle_id() {
        return salle_id;
    }

    public void setSalle_id(int salle_id) {
        this.salle_id = salle_id;
    }



    @Override
    public String toString() {
        return "Session{" +
                "session_id=" + session_id +
                ", professor_id=" + professor_id +
                ", subject_id=" + subject_id +
                ", salle_id=" + salle_id +
                '}';
    }
}
