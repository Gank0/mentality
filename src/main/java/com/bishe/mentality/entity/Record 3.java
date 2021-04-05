package com.bishe.mentality.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Record {
    private String s_no;
    //private Date time;
    private int Testno1;
    private String answer1;
    private int Testno2;
    private String answer2;
    private int Testno3;
    private String answer3;
    private int Testno4;
    private String answer4;
    private int Testno5;
    private String answer5;
    private int score;

    public String getS_no() {
        return s_no;
    }

    public void setS_no(String s_no) {
        this.s_no = s_no;
    }

    public int getTestno1() {
        return Testno1;
    }

    public void setTestno1(int testno1) {
        Testno1 = testno1;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public int getTestno2() {
        return Testno2;
    }

    public void setTestno2(int testno2) {
        Testno2 = testno2;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public int getTestno3() {
        return Testno3;
    }

    public void setTestno3(int testno3) {
        Testno3 = testno3;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public int getTestno4() {
        return Testno4;
    }

    public void setTestno4(int testno4) {
        Testno4 = testno4;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public int getTestno5() {
        return Testno5;
    }

    public void setTestno5(int testno5) {
        Testno5 = testno5;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
