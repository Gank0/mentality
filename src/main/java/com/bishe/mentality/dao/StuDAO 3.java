package com.bishe.mentality.dao;

import com.bishe.mentality.entity.Student;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface StuDAO {
    void saveStu(Student student);
    Student loginStu(@Param("s_no") String s_no,@Param("s_password") String s_password);
    List<Student> findAllStu();
    void deleteStu(@Param("s_no") String s_no);
    Student findStu(@Param("s_no") String s_no);
    void editStu(Student student);

}
