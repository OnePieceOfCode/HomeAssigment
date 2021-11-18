package com.example.advertisinganalizator.service.impl;

import com.example.advertisinganalizator.io.repo.ClickRepo;
import com.example.advertisinganalizator.io.repo.ImpressionRepo;
import com.example.advertisinganalizator.io.repo.UsersRequestRepo;
import com.example.advertisinganalizator.service.AnalyzerService;
import com.example.advertisinganalizator.service.dto.AnalyzerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnalyzerServiceImpl implements AnalyzerService {

    private final UsersRequestRepo usersRequestRepo;
    private final ClickRepo clickRepo;
    private final ImpressionRepo impressionRepo;

    @Autowired
    public AnalyzerServiceImpl(UsersRequestRepo usersRequestRepo, ClickRepo clickRepo, ImpressionRepo impressionRepo) {
        this.usersRequestRepo = usersRequestRepo;
        this.clickRepo = clickRepo;
        this.impressionRepo = impressionRepo;
    }

    @Override
    public AnalyzerDto analyzerByUserId(String userId) {

        //TODO code for creating dto -> response.

        return null;
    }
}
