package com.example.advertisinganalizator.controller.controllers;

import com.example.advertisinganalizator.controller.model.OperationResponse;
import com.example.advertisinganalizator.controller.model.OperationResult;
import com.example.advertisinganalizator.controller.model.PathRequest;
import com.example.advertisinganalizator.controller.model.RequestOperationName;
import com.example.advertisinganalizator.service.LoadCSVFilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/csv")
public class ManageCsvController {

    private final LoadCSVFilesService loadCSVFilesService;

    @Autowired
    public ManageCsvController(LoadCSVFilesService loadCSVFilesService) {
        this.loadCSVFilesService = loadCSVFilesService;
    }


    @PutMapping("/usersRequests")
    public OperationResponse uploadUsersRequestsCsv(@RequestBody PathRequest pathRequest) {
        OperationResponse operationResponse = new OperationResponse();
        operationResponse.setOperationName(RequestOperationName.UPLOAD_CSV_REQUESTS.name());
        int res = loadCSVFilesService.loadUsersRequestsFiles(pathRequest.getPath());
        if(res == 0) {
            return setError(operationResponse, res);
        }
        operationResponse.setOperationResult(OperationResult.SUCCESS.name());
        operationResponse.setCountEntities(String.valueOf(res));
        return operationResponse;
    }

    private OperationResponse setError(OperationResponse operationResponse, int res) {
        operationResponse.setOperationResult(OperationResult.ERROR.name());
        operationResponse.setCountEntities(String.valueOf(res));
        return operationResponse;
    }


    @PutMapping("/clicks")
    public OperationResponse uploadClicksCsv(@RequestBody PathRequest pathRequest) {
        OperationResponse operationResponse = new OperationResponse();
        operationResponse.setOperationName(RequestOperationName.UPLOAD_CSV_CLICKS.name());
        int res = loadCSVFilesService.loadClicksFiles(pathRequest.getPath());
        if(res == 0) {
            return setError(operationResponse, res);
        }
        operationResponse.setOperationResult(OperationResult.SUCCESS.name());
        operationResponse.setCountEntities(String.valueOf(res));
        return operationResponse;
    }

    @PutMapping("/impressions")
    public OperationResponse uploadImpressionsCsv(@RequestBody PathRequest pathRequest) {
        OperationResponse operationResponse = new OperationResponse();
        operationResponse.setOperationName(RequestOperationName.UPLOAD_CSV_IMPRESSIONS.name());
        int res = loadCSVFilesService.loadImpressionsFiles(pathRequest.getPath());
        if(res == 0) {
            return setError(operationResponse, res);
        }
        operationResponse.setOperationResult(OperationResult.SUCCESS.name());
        operationResponse.setCountEntities(String.valueOf(res));
        return operationResponse;
    }
}
