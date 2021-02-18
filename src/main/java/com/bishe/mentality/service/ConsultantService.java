package com.bishe.mentality.service;

import com.bishe.mentality.entity.Consultant;

import java.util.Date;
import java.util.List;

public interface ConsultantService {
    Consultant loginCon(String id,String password);
    List<Consultant> findAllCon();
    Consultant findCon(String id);
    List<Date> busyDay(String id);

}
