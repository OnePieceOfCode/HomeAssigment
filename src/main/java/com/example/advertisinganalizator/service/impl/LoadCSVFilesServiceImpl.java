package com.example.advertisinganalizator.service.impl;


import com.example.advertisinganalizator.io.entity.UsersRequest;
import com.example.advertisinganalizator.io.repo.UsersRequestRepo;
import com.example.advertisinganalizator.service.LoadCSVFilesService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class LoadCSVFilesServiceImpl implements LoadCSVFilesService {

    final UsersRequestRepo usersRequestRepo;

    @Autowired
    public LoadCSVFilesServiceImpl(UsersRequestRepo usersRequestRepo) {
        this.usersRequestRepo = usersRequestRepo;
    }


    @Override
    public void loadUsersRequestsFiles(String fileName) {
        try(Reader reader = Files.newBufferedReader(Paths.get(fileName));
            CSVReader csvReader = new CSVReader(reader)) {

            String[] record;
            while ((record = csvReader.readNext()) != null) {
                UsersRequest usersRequest = UsersRequest.builder()
                        .epochTimestamp(record[0])
                        .session_id(record[1])
                        .partner(record[2])
                        .user_id(record[3])
                        .bid(Float.valueOf(record[4]))
                        .isWin(Boolean.valueOf(record[5]))
                        .build();

                usersRequestRepo.save(usersRequest);
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
    }
    //TODO create methods for another tables
    @Override
    public void loadClicksFiles(String fileName) {

    }

    @Override
    public void loadImpressionsFiles(String fileName) {

    }
}
