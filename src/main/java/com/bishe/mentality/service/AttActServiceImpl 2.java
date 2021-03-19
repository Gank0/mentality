package com.bishe.mentality.service;

import com.bishe.mentality.dao.AttActDAO;
import com.bishe.mentality.entity.AttenActivity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttActServiceImpl implements AttActService{
    @Autowired
    AttActDAO attActDAO;

    @Override
    public void AddAttAct(AttenActivity attenActivity) {
        attActDAO.AddAttAct(attenActivity);
    }

    @Override
    public List<AttenActivity> FindAttBysno(String s_no) {
        return attActDAO.FindAttBysno(s_no);
    }
}
