package com.bishe.mentality.service;

import com.bishe.mentality.dao.AdmDAO;
import com.bishe.mentality.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdmDAO admDAO;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Admin> findAllAdmin() {
        return admDAO.findAllAdmin();
    }

    @Override
    public void saveAdmin(Admin admin) {
        admDAO.addAdmin(admin);
    }

    @Override
    public void deleteAdmin(String id) {
        admDAO.deleteAdmin(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin findAdmin(String id) {
        return admDAO.findAdmin(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public void updateAdmin(Admin admin) {
        admDAO.editAdmin(admin);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Admin loginAdmin(String id, String password) {
        return admDAO.loginAdmin(id,password);
    }
}
