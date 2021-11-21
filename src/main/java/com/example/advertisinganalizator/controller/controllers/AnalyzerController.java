package com.example.advertisinganalizator.controller.controllers;

import com.example.advertisinganalizator.controller.model.AnalyzeResponse;
import com.example.advertisinganalizator.service.AnalysisService;
import com.example.advertisinganalizator.service.dto.AnalyzerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userStats")
public class AnalyzerController {

    private final AnalysisService analysisService;

    @Autowired
    public AnalyzerController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }

    @GetMapping(path = "/{user_id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public AnalyzeResponse getUserAnalysis(@PathVariable String user_id) {
        AnalyzerDto analyzerDto = analysisService.analyzerByUserId(user_id);
        AnalyzeResponse returnValue = AnalyzeResponse.builder()
                .user_id(analyzerDto.getUserId())
                .averagePrice(analyzerDto.getAveragePrice())
                .numClicks(analyzerDto.getNumClicks().toString())
                .numImpressions(analyzerDto.getNumImpressions().toString())
                .numRequests(analyzerDto.getNumRequests().toString())
                .build();
                //= new AnalyzeResponse();
        //ModelMapper modelMapper = new ModelMapper();
        //returnValue = modelMapper.map(analyzerDto, AnalyzeResponse.class);

        return returnValue;
    }

}
