package com.example.advertisinganalizator.factory.impl;

import com.example.advertisinganalizator.factory.CreateAnalysisFactory;
import com.example.advertisinganalizator.io.repo.ClickRepo;
import com.example.advertisinganalizator.io.repo.ImpressionRepo;
import com.example.advertisinganalizator.io.repo.UsersRequestRepo;
import com.example.advertisinganalizator.service.dto.AnalyzerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateAnalysisFactoryImpl implements CreateAnalysisFactory {

    private final UsersRequestRepo usersRequestRepo;
    private final ClickRepo clickRepo;
    private final ImpressionRepo impressionRepo;

    @Autowired
    public CreateAnalysisFactoryImpl(UsersRequestRepo usersRequestRepo, ClickRepo clickRepo, ImpressionRepo impressionRepo) {
        this.usersRequestRepo = usersRequestRepo;
        this.clickRepo = clickRepo;
        this.impressionRepo = impressionRepo;
    }

    @Override
    public AnalyzerDto analysisByUserId(String userId) {
        List<Object[]> sessionIds = usersRequestRepo.findAllSessionIdByUserId(userId);

        return AnalyzerDto.builder()
                .userId(userId)
                .numRequests(countRequestsNum(userId))
                .numImpressions(countImpressions(sessionIds))
                .numClicks(countClicks(sessionIds))
                .averagePrice(countAvgPrice(userId))
                .build();
    }

    private String countAvgPrice(String userId) {
        Double avg = usersRequestRepo.countAvgBidByUserIdAndWinTrue(userId).orElse(0.0);
        return String.format("%.3f", avg);
    }

    private Long countClicks(List<Object[]> timePass) {
        long res = 0L;
        for(Object[] oneTimePass : timePass) {
            Long sum = clickRepo.countSumTimePassBySessionId(oneTimePass[0].toString()).orElse(0L);
            res += sum;
        }
        return res;
    }

    private Long countImpressions(List<Object[]>  sessionIds) {
        long res = 0L;
        for(Object[] sessionId : sessionIds) {
            Long sum = impressionRepo.countSumDurationBySessionId(sessionId[0].toString()).orElse(0L);
            res += sum;
        }
        return res;
    }

    private Long countRequestsNum(String userId) {
        return usersRequestRepo.countByUserId(userId).orElse(0L);

    }
}
