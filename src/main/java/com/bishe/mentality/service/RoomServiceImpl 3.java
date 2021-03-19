package com.bishe.mentality.service;


import com.bishe.mentality.dao.ConroomDAO;
import com.bishe.mentality.entity.Conroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    ConroomDAO conroomDAO;

    @Override
    public List<Conroom> findAllRoom() {
        List<Conroom> allRoom=conroomDAO.findAllRoom();
        return allRoom;
    }
}
