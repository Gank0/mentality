package com.bishe.mentality.dao;

import com.bishe.mentality.entity.Testquestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestqDAO {
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
