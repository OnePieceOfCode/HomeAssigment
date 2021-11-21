package com.example.advertisinganalizator.service.impl;

import com.example.advertisinganalizator.factory.CreateAnalysisFactory;
import com.example.advertisinganalizator.service.AnalysisService;
import com.example.advertisinganalizator.service.dto.AnalyzerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AnalysisServiceImpl implements AnalysisService {

    private final CreateAnalysisFactory createAnalysisFactory;

    @Autowired
    public AnalysisServiceImpl(CreateAnalysisFactory createAnalysisFactory) {
        this.createAnalysisFactory = createAnalysisFactory;
    }

    @Override
    public AnalyzerDto analyzerByUserId(String userId) {
//TODO improve with additional table for analysis entity(flyweight)
       AnalyzerDto analyzerDto = createAnalysisFactory.analysisByUserId(userId);

        return analyzerDto;
    }

}
