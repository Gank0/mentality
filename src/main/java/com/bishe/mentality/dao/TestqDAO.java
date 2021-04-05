package com.bishe.mentality.dao;

import com.bishe.mentality.entity.Testquestion;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestqDAO {
    void addQ(Testquestion testquestion);//没加type
    List<Testquestion> findAllQ();
    void updateQ(Testquestion testquestion);//没加type
    Testquestion findQByNo(int Testno);
    void deleteQByNo(int Testno);
    List<Testquestion> randomSelect0();
    List<Testquestion> randomSelect1();
    List<Testquestion> randomSelect2();
    List<Testquestion> randomSelect3();

    int scoreA(int Testno);
    int scoreB(int Testno);
    int scoreC(int Testno);
    int scoreD(int Testno);
    int typeQ(int Testno);
}
