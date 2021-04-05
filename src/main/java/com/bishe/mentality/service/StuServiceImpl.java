package com.bishe.mentality.service;

import com.bishe.mentality.dao.StuDAO;
import com.bishe.mentality.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StuServiceImpl implements StuService {


    @Autowired
    StuDAO stuDAO;


    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void register(Student student) {
        stuDAO.saveStu(student);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Student login(String id, String pwd) {
        return stuDAO.loginStu(id, pwd);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Student> findAllStu() {
        return stuDAO.findAllStu();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void deleteStu(String s_no) {
        stuDAO.deleteStu(s_no);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Student findStu(String s_no) {
        return stuDAO.findStu(s_no);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void editStu(Student student) {
        stuDAO.editStu(student);
    }

    @Override
    public List<Student> ALLbjy() {
        return stuDAO.ALLbjy();
    }
}
