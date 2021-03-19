package com.bishe.mentality.dao;

import com.bishe.mentality.entity.Record;

import java.util.List;

public interface RecordDAO {
    void saveRecord(Record record);
    List<Record> findAllRecord();
    Record findRecord(String s_no);
}
