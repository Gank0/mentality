package com.bishe.mentality.service;

import com.bishe.mentality.entity.Leave;

import java.util.List;

public interface LeaveService {
    void addLeave(Leave leave);
    void editLeave(Leave leave);
    List<Leave> findAllLeave();
    List<Leave> findLeaveByid(String id);
    Leave findLeaveByNo(int leaveNo);
}
