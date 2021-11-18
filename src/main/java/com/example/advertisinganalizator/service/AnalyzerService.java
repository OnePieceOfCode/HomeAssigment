package com.example.advertisinganalizator.service;

import com.example.advertisinganalizator.service.dto.AnalyzerDto;

public interface AnalyzerService {

    AnalyzerDto analyzerByUserId(String userId);
}
