package com.bishe.mentality.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class collegeAvg {
    private Double avgs;
    private String s_college;

    public Double getAvgs() {
        return avgs;
    }

    public void setAvgs(Double avgs) {
        this.avgs = avgs;
    }

    public String getS_college() {
        return s_college;
    }

    public void setS_college(String s_college) {
        this.s_college = s_college;
    }
}
