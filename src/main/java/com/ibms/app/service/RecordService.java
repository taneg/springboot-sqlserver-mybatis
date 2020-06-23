package com.ibms.app.service;

import com.ibms.app.beans.Record;

import java.util.List;

public interface RecordService {
    List<Record> list(Record record);
}
