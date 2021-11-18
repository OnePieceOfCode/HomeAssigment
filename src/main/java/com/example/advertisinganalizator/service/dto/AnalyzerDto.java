package com.example.advertisinganalizator.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AnalyzerDto {

    private String user_id;
    private String numRequests;
    private String numImpressions;
    private String numClicks;
    private String averagePrice;

}
