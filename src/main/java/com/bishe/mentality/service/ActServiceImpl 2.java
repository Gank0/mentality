package com.bishe.mentality.service;

import com.bishe.mentality.dao.ActDAO;
import com.bishe.mentality.entity.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActServiceImpl implements ActService{

    @Autowired
    ActDAO actDAO;
    @Override
    public void addAct(Activity activity) {
        actDAO.addAct(activity);
    }

    @Override
    public List<Activity> allAct() {
        return actDAO.allAct();
    }

    @Override
    public void editStateByNo(String ActNo) {
        actDAO.editStateByNo(ActNo);
    }
}
