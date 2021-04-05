package com.bishe.mentality.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScoreAndStu {
    private Integer e_score;
    private String s_college;
    private String s_no;
    private String s_name;
    private String s_grade;
    private Integer s_gender;

}
