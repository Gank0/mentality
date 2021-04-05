package com.bishe.mentality.service;

import com.bishe.mentality.dao.LeaveDAO;
import com.bishe.mentality.entity.Leave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    LeaveDAO leaveDAO;


    @Override
    public void addLeave(Leave leave) {
        leaveDAO.addLeave(leave);
    }

    @Override
    public void editLeave(Leave leave) {
        leaveDAO.editLeave(leave);
    }

    @Override
    public List<Leave> findAllLeave() {
        return leaveDAO.findAllLeave();
    }

    @Override
    public List<Leave> findLeaveByid(String id) {
        return leaveDAO.findLeaveByid(id);
    }

    @Override
    public Leave findLeaveByNo(int leaveNo) {
        return leaveDAO.findLeaveByNo(leaveNo);
    }
}
