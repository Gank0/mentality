package com.bishe.mentality.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Conroom {
    private String roomName;
    private int roomState;
    private String roomdescribe;//描述

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomState() {
        return roomState;
    }

    public void setRoomState(int roomState) {
        this.roomState = roomState;
    }

    public String getRoomdescribe() {
        return roomdescribe;
    }

    public void setRoomdescribe(String roomdescribe) {
        this.roomdescribe = roomdescribe;
    }
}
