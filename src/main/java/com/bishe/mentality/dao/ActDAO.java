package com.bishe.mentality.dao;

import com.bishe.mentality.entity.Activity;

import java.util.List;

public interface ActDAO {
    void addAct(Activity activity);
    List<Activity> allAct();
    void editStateByNo(String ActNo);
}
