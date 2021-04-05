package com.bishe.mentality.service;

import com.bishe.mentality.dao.AppoDAO;
import com.bishe.mentality.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class AppoServiceImpl implements AppoService{
    @Autowired
    AppoDAO appoDAO;

    @Override
    public void creatAppo(Appointment appointment) {
        appoDAO.creatAppo(appointment);
    }

    @Override
    public List<Appointment> findAppoBycid(String c_id) {
        List<Appointment> appoList=appoDAO.findAppoBycid(c_id);
        return appoList;
    }

    @Override
    public List<Appointment> findAppoBysno(String s_no) {
        List<Appointment> appoList=appoDAO.findAppoBysno(s_no);
        return appoList;
    }

    @Override
    public List<Appointment> findAllAppo() {
        List<Appointment> appoList=appoDAO.findAllAppo();
        return appoList;
    }

    @Override
    public Appointment findAppoByno(String no) {
        return appoDAO.findAppoByno(no);
    }

    @Override
    public void updateAppo(Appointment appointment) {
        appoDAO.updateAppo(appointment);
    }

    @Override
    public List<Appointment> findConBetweenDate(Date startDate, Date endDate,String cid) {
        return appoDAO.findConBetweenDate(startDate,endDate,cid);
    }
}
