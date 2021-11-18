package com.example.advertisinganalizator.controller.controllers;

import com.example.advertisinganalizator.controller.model.AnalyzeResponse;
import com.example.advertisinganalizator.controller.model.PathRequest;
import com.example.advertisinganalizator.service.AnalyzerService;
import com.example.advertisinganalizator.service.LoadCSVFilesService;
import com.example.advertisinganalizator.service.dto.AnalyzerDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userStats")
public class AnalyzerController {

    private final AnalyzerService analyzerService;
    private final LoadCSVFilesService loadCSVFilesService;

    @Autowired
    public AnalyzerController(AnalyzerService analyzerService, LoadCSVFilesService loadCSVFilesService) {
        this.analyzerService = analyzerService;
        this.loadCSVFilesService = loadCSVFilesService;
    }

    @GetMapping(path = "/{user_id}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public AnalyzeResponse getUser(@PathVariable String user_id) {
        AnalyzeResponse returnValue = new AnalyzeResponse();
        AnalyzerDto analyzerDto = analyzerService.analyzerByUserId(user_id);
        ModelMapper modelMapper = new ModelMapper();
        returnValue = modelMapper.map(analyzerDto, AnalyzeResponse.class);

        return returnValue;
    }
//TODO another controller for choose a way&place converting
    @PostMapping("/csv")
    public void uploadUsersRequestsCsv(@RequestBody PathRequest pathRequest) {

        loadCSVFilesService.loadUsersRequestsFiles(pathRequest.getPath());
    }
}
