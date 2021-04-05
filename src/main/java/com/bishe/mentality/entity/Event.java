package com.bishe.mentality.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private int E_no;
    private String s_no;
    private int e_type;//0室内活动  1户外活动   2讲座/茶话会类  3其他
    private String e_name;
    private String e_detail;
    private int e_score;

    public int getE_no() {
        return E_no;
    }

    public void setE_no(int e_no) {
        E_no = e_no;
    }

    public String getS_no() {
        return s_no;
    }

    public void setS_no(String s_no) {
        this.s_no = s_no;
    }

    public int getE_type() {
        return e_type;
    }

    public void setE_type(int e_type) {
        this.e_type = e_type;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_detail() {
        return e_detail;
    }

    public void setE_detail(String e_detail) {
        this.e_detail = e_detail;
    }

    public int getE_score() {
        return e_score;
    }

    public void setE_score(int e_score) {
        this.e_score = e_score;
    }
}
