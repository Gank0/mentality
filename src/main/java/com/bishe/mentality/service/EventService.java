package com.bishe.mentality.service;

import com.bishe.mentality.entity.Event;
import com.bishe.mentality.entity.ScoreAndStu;
import com.bishe.mentality.entity.collegeAvg;
import com.bishe.mentality.entity.collegeSum;

import java.util.List;
import java.util.Map;

public interface EventService {
    List<Event> FindAllEvent();
    List<Event> FindEventById(String id);
    List<Event> FindEventByCollege(String college);
    void AddEvent(Event event);
    void updateScore(int E_no,int e_score);
    Event FindEventByEno(int E_no);
    List<ScoreAndStu> RankScore();
    List<collegeSum> countEventCollege();
    List<collegeAvg> avgsEventCollege();
}
