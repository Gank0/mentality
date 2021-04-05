package com.bishe.mentality.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Appointment {
    private int appointNo;
    private String s_no;
    private String c_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date appTime;
    private int timePart;
    private int important;
    private String appRoom;
    private int score;
    private int state;
    private String note;

    public Appointment() {
    }

    public Appointment(int appointNo, String s_no, String c_id, Date appTime, int timePart, int important, String appRoom, int score, int state, String note) {
        this.appointNo = appointNo;
        this.s_no = s_no;
        this.c_id = c_id;
        this.appTime = appTime;
        this.timePart = timePart;
        this.important = important;
        this.appRoom = appRoom;
        this.score = score;
        this.state = state;
        this.note = note;
    }

    public int getTimePart() {
        return timePart;
    }

    public void setTimePart(int timePart) {
        this.timePart = timePart;
    }

    public int getAppointNo() {
        return appointNo;
    }

    public void setAppointNo(int appointNo) {
        this.appointNo = appointNo;
    }

    public String getS_no() {
        return s_no;
    }

    public void setS_no(String s_no) {
        this.s_no = s_no;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public Date getAppTime() {
        return appTime;
    }

    public void setAppTime(Date appTime) {
        this.appTime = appTime;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    public String getAppRoom() {
        return appRoom;
    }

    public void setAppRoom(String appRoom) {
        this.appRoom = appRoom;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointNo=" + appointNo +
                ", s_no='" + s_no + '\'' +
                ", c_id='" + c_id + '\'' +
                ", appTime=" + appTime +
                ", timePart=" + timePart +
                ", important=" + important +
                ", appRoom='" + appRoom + '\'' +
                ", score=" + score +
                ", state=" + state +
                ", note='" + note + '\'' +
                '}';
    }
}
