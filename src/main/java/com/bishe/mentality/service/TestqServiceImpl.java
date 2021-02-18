package com.bishe.mentality.service;


import com.bishe.mentality.dao.TestqDAO;
import com.bishe.mentality.entity.Testquestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestqServiceImpl implements TestqService {

    @Autowired
    TestqDAO testqDAO;


    @Override
    public void addQ(Testquestion testquestion) {
        testqDAO.addQ(testquestion);
    }

    @Override
    public List<Testquestion> findAllQ() {
        List<Testquestion> ques=testqDAO.findAllQ();
        return ques;
    }

    @Override
    public void updateQ(Testquestion testquestion) {
        testqDAO.updateQ(testquestion);
    }

    @Override
    public Testquestion findQByNo(int Testno) {
        return testqDAO.findQByNo(Testno);
    }

    @Override
    public void deleteQByNo(int Testno) {
        testqDAO.deleteQByNo(Testno);
    }

    @Override
    public List<Testquestion> randomSelect() {
        return testqDAO.randomSelect();
    }

    @Override
    public int scoreA(int Testno) {
        return testqDAO.scoreA(Testno);
    }

    @Override
    public int scoreB(int Testno) {
        return testqDAO.scoreB(Testno);
    }

    @Override
    public int scoreC(int Testno) {
        return testqDAO.scoreC(Testno);
    }

    @Override
    public int scoreD(int Testno) {
        return testqDAO.scoreD(Testno);
    }
}
