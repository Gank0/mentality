package com.bishe.mentality.dao;

import com.bishe.mentality.entity.Appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppoDAO {
    void creatAppo(Appointment appointment);
    List<Appointment>  findAppoBycid(String c_id);
    List<Appointment>  findAppoBysno(String s_no);
    List<Appointment> findAllAppo();
    Appointment findAppoByno(String no);
    void updateAppo(Appointment appointment);
}
