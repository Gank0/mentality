package com.bishe.mentality.dao;

import com.bishe.mentality.entity.Conroom;

import java.util.List;

public interface ConroomDAO {
    List<Conroom> findAllRoom();
    void deleteRoom(String roomName);
    void updateRoom(Conroom conroom);
    Conroom findRoomByName(String roomName);
    void addRoom(Conroom conroom);
}
