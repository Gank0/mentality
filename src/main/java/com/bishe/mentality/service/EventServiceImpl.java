package com.bishe.mentality.service;

import com.bishe.mentality.dao.EventDAO;
import com.bishe.mentality.entity.Event;
import com.bishe.mentality.entity.ScoreAndStu;
import com.bishe.mentality.entity.collegeAvg;
import com.bishe.mentality.entity.collegeSum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EventServiceImpl implements EventService {

    @Autowired
    EventDAO eventDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Event> FindAllEvent() {
        return eventDAO.FindAllEvent();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Event> FindEventById(String id) {
        return eventDAO.FindEventById(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Event> FindEventByCollege(String college) {
        return eventDAO.FindEventByCollege(college);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void AddEvent(Event event) {
        eventDAO.AddEvent(event);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateScore(int E_no, int e_score) {
        eventDAO.updateScore(E_no,e_score);
    }

    @Override
    public Event FindEventByEno(int E_no) {
        return eventDAO.FindEventByEno(E_no);
    }

    @Override
    public List<ScoreAndStu> RankScore() {
        return eventDAO.RankScore();
    }

    @Override
    public List<collegeSum> countEventCollege() {
        return eventDAO.countEventCollege();
    }

    @Override
    public List<collegeAvg> avgsEventCollege() {
        return eventDAO.avgsEventCollege();
    }


}
