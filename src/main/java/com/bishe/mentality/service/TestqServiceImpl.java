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
    public List<Testquestion> randomSelect0() {
        return testqDAO.randomSelect0();
    }

    @Override
    public List<Testquestion> randomSelect1() {
        return testqDAO.randomSelect1();
    }

    @Override
    public List<Testquestion> randomSelect2() {
        return testqDAO.randomSelect2();
    }

    @Override
    public List<Testquestion> randomSelect3() {
        return testqDAO.randomSelect3();
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

    @Override
    public int typeQ(int Testno) {
        return testqDAO.typeQ(Testno);
    }
}
