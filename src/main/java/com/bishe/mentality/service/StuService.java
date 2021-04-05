package com.bishe.mentality.service;

import com.bishe.mentality.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StuService {
    void register(Student student);
    Student login(String s_no,String s_password);
    List<Student> findAllStu();
    void deleteStu(String s_no);
    Student findStu(String s_no);
    void editStu(Student student);
    List<Student> ALLbjy();
}
