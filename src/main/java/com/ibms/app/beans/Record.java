package com.ibms.app.beans;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Record {
    private Integer kid;
    private String deviceSn;
    private Integer currentTemp;
    private Integer currentHumidity;
    private String fetchTime;
    private Integer outputflag;
}
