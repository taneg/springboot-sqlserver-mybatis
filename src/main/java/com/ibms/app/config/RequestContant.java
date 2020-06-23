package com.ibms.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "device")
@Component
@Data
public class RequestContant {
    private String storeMedicine;
    private String orderInfo;
    private String monitor;
    private String cipher;
}
