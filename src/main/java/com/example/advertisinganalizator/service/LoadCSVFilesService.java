package com.example.advertisinganalizator.service;

public interface LoadCSVFilesService {

    int loadUsersRequestsFiles(String fileName);
    int loadClicksFiles(String fileName);
    int loadImpressionsFiles(String fileName);
}
