package com.bishe.mentality.service;

import com.bishe.mentality.dao.RecordDAO;
import com.bishe.mentality.entity.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordDAO recordDAO;

    @Override
    public void saveRecord(Record record) {
        recordDAO.saveRecord(record);
    }

    @Override
    public List<Record> findAllRecord() {
        return recordDAO.findAllRecord();
    }

    @Override
    public Record findRecord(int R_no) {
        return recordDAO.findRecord(R_no);
    }

    @Override
    public List<Record> lowRecord(int score) {
        return recordDAO.lowRecord(score);
    }
}
