package com.bishe.mentality.service;

import com.bishe.mentality.entity.AttenActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttActService {
    void AddAttAct(AttenActivity attenActivity);
    List<AttenActivity> FindAttBysno(@Param("s_no")String s_no);
}
