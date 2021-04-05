package com.bishe.mentality.service;

import com.bishe.mentality.entity.Record;

import java.util.List;


public interface RecordService {
    void saveRecord(Record record);
    List<Record> findAllRecord();
    Record findRecord(String s_no);
    List<Record> lowRecord(int score);
}
