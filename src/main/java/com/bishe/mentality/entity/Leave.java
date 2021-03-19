package com.bishe.mentality.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Leave {
    private int leaveNo;
    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leaveStartTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leaveEndTime;
    private int leaveType;//0 事假  1病假 2其他
    private String leaveReason;
    private int state; //0 待审核  1 审核通过 2审核不通过

    public int getLeaveNo() {
        return leaveNo;
    }

    public void setLeaveNo(int leaveNo) {
        this.leaveNo = leaveNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLeaveStartTime() {
        return leaveStartTime;
    }

    public void setLeaveStartTime(Date leaveStartTime) {
        this.leaveStartTime = leaveStartTime;
    }

    public Date getLeaveEndTime() {
        return leaveEndTime;
    }

    public void setLeaveEndTime(Date leaveEndTime) {
        this.leaveEndTime = leaveEndTime;
    }

    public int getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(int leaveType) {
        this.leaveType = leaveType;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
