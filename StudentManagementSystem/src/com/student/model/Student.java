package com.student.model;

public class Student {
private int rollNum;
private String Name;
private String clgName;
private String city;
private  double percentage;
    public Student(){

    }

    public Student(String name, String clgName, String city, double percentage) {
        this.Name = name;
        this.clgName = clgName;
        this.city = city;
        this.percentage = percentage;
    }
    public Student(int rollNum, String name, String clgName, String city, double percentage) {
        this.rollNum = rollNum;
         this.Name = name;
        this.clgName = clgName;
        this.city = city;
        this.percentage = percentage;
    }

    public int getRollNum() {
        return rollNum;
    }

    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getClgName() {
        return clgName;
    }

    public void setClgName(String clgName) {
        this.clgName = clgName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNum=" + rollNum +
                ", Name='" + Name + '\'' +
                ", clgName='" + clgName + '\'' +
                ", city='" + city + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
