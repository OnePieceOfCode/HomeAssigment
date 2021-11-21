package com.example.advertisinganalizator.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AnalyzerDto {

    private String userId;
    private Long numRequests;
    private Long numImpressions;
    private Long numClicks;
    private String averagePrice;

}
