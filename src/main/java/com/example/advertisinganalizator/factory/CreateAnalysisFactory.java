package com.example.advertisinganalizator.factory;

import com.example.advertisinganalizator.service.dto.AnalyzerDto;

public interface CreateAnalysisFactory {

    AnalyzerDto analysisByUserId(String userId);
}
