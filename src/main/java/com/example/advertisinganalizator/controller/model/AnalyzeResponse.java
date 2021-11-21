package com.example.advertisinganalizator.controller.model;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzeResponse {

    private String user_id;
    private String numRequests;
    private String numImpressions;
    private String numClicks;
    private String averagePrice;
}
