package com.bishe.mentality.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private String s_no;
    private String s_name;
    private String s_password;
    private int s_gender; //男0 女1
    private String s_college;
    private String s_grade;//年级
    private int hygienist;//保健员0 非保健员1

    public String getS_no() {
        return s_no;
    }

    public void setS_no(String s_no) {
        this.s_no = s_no;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_password() {
        return s_password;
    }

    public void setS_password(String s_password) {
        this.s_password = s_password;
    }

    public int getS_gender() {
        return s_gender;
    }

    public void setS_gender(int s_gender) {
        this.s_gender = s_gender;
    }

    public String getS_college() {
        return s_college;
    }

    public void setS_college(String s_college) {
        this.s_college = s_college;
    }

    public String getS_grade() {
        return s_grade;
    }

    public void setS_grade(String s_grade) {
        this.s_grade = s_grade;
    }

    public int getHygienist() {
        return hygienist;
    }

    public void setHygienist(int hygienist) {
        this.hygienist = hygienist;
    }
}
