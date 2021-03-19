package com.bishe.mentality.service;

import com.bishe.mentality.dao.ConsuDAO;
import com.bishe.mentality.entity.Consultant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ConsultantServiceImpl implements ConsultantService{

    @Autowired
    ConsuDAO consuDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Consultant loginCon(String id, String password) {
        Consultant consultant=consuDAO.conlogin(id,password);
        return consultant;
    }

    @Override
    public List<Consultant> findAllCon() {
        return consuDAO.findAllCon();
    }

    @Override
    public Consultant findCon(String id) {
        return consuDAO.findCon(id);
    }

    @Override
    public List<Date> busyDay(String id) {
        return consuDAO.busyDay(id);
    }
}
