package com.ibms.app.controller;

import com.ibms.app.beans.Record;
import com.ibms.app.dao.RecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("app")
public class AppController {
    @Autowired
    private RecordMapper recordMapper;

    @GetMapping("test")
    public String test() {
        Record record = Record.builder()
                .deviceSn("444")
                .currentHumidity(333)
                .currentTemp(555)
                .fetchTime("2020-06-23 10:35:00")
                .outputflag(2)
                .build();
        int i = recordMapper.insert(record);
        return String.valueOf(i);
    }
}
