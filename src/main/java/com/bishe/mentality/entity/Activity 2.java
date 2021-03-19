package com.bishe.mentality.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Activity {
    private String ActNo;
    private String ActName;
    private String ActImg;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ActTime;
    private String ActPlace;
    private String ActNote;
    private int State;
}
