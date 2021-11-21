package com.example.advertisinganalizator.service;

import com.example.advertisinganalizator.service.dto.AnalyzerDto;

public interface AnalysisService {

    AnalyzerDto analyzerByUserId(String userId);
}
