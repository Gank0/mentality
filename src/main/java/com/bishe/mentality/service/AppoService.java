package com.bishe.mentality.service;

import com.bishe.mentality.entity.Appointment;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface AppoService {
    void creatAppo(Appointment appointment);
    List<Appointment> findAppoBycid(String c_id);
    List<Appointment> findAppoBysno(String s_no);
    List<Appointment> findAllAppo();
    Appointment findAppoByno(String no);
    void updateAppo(Appointment appointment);
    List<Appointment> findConBetweenDate(Date startDate, Date endDate,String cid);
    List<Appointment> findAppByRoom(String appRoom);
}
