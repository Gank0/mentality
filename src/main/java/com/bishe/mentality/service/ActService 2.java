package com.bishe.mentality.service;

import com.bishe.mentality.entity.Activity;

import java.util.List;

public interface ActService {
    void addAct(Activity activity);
    List<Activity> allAct();
    void editStateByNo(String ActNo);
}
