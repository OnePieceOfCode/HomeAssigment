package com.example.advertisinganalizator.service;

public interface LoadCSVFilesService {

    void loadUsersRequestsFiles(String fileName);
    void loadClicksFiles(String fileName);
    void loadImpressionsFiles(String fileName);
}
