package com.bishe.mentality.dao;

import com.bishe.mentality.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdmDAO {
    List<Admin> findAllAdmin();
    void addAdmin(Admin admin);
    void deleteAdmin(String id);
    Admin findAdmin(String id);
    void editAdmin(Admin admin);
    Admin loginAdmin(@Param("id") String id,@Param("password") String password);
}
