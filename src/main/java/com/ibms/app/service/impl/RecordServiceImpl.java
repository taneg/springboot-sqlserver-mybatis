package com.ibms.app.service.impl;

import com.ibms.app.beans.Record;
import com.ibms.app.dao.RecordMapper;
import com.ibms.app.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    @Override
    public List<Record> list(Record record) {
        return null;
    }
}
