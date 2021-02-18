package com.bishe.mentality.service;

import com.bishe.mentality.entity.Testquestion;

import java.util.List;

public interface TestqService {
    void addQ(Testquestion testquestion);
    List<Testquestion> findAllQ();
    void updateQ(Testquestion testquestion);
    Testquestion findQByNo(int Testno);
    void deleteQByNo(int Testno);
    List<Testquestion> randomSelect();
    int scoreA(int Testno);
    int scoreB(int Testno);
    int scoreC(int Testno);
    int scoreD(int Testno);
}
