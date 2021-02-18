package com.bishe.mentality.service;

import com.bishe.mentality.entity.Admin;

import java.util.List;

public interface AdminService {
    List<Admin> findAllAdmin();
    void saveAdmin(Admin admin);
    void deleteAdmin(String id);
    Admin findAdmin(String id);
    void updateAdmin(Admin admin);
    Admin loginAdmin(String id,String password);
}
