package com.bishe.mentality.dao;

import com.bishe.mentality.entity.Consultant;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ConsuDAO {
    Consultant conlogin(@Param("id") String id, @Param("password") String password);
    List<Consultant> findAllCon();
    Consultant findCon(String id);
    List<Date> busyDay(String c_id);
    void editCon(Consultant consultant);
    void deleteCon(String id);


}
