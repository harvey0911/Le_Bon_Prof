package com.example.lebonprof;

public class Student {


    private String first_name;
    private String last_name;
    private String Phone_number;

    private double amount;

    public Student(String first_name, String last_name, String phone_number, double amount) {
        this.first_name = first_name;
        this.last_name = last_name;
        Phone_number = phone_number;
        this.amount = amount;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "com.example.lebonprof.Student{" +
                "first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", amount=" + amount +
                '}';
    }
}
