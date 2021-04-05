package com.bishe.mentality.service;

import com.bishe.mentality.entity.Conroom;

import java.util.List;

public interface RoomService {
    List<Conroom> findAllRoom();
    void deleteRoom(String roomName);
    void updateRoom(Conroom conroom);
    Conroom findRoomByName(String roomName);
    void addRoom(Conroom conroom);
}
