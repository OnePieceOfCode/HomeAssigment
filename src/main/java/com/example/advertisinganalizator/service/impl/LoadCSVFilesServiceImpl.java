package com.example.advertisinganalizator.service.impl;


import com.example.advertisinganalizator.io.entity.Click;
import com.example.advertisinganalizator.io.entity.Impression;
import com.example.advertisinganalizator.io.entity.UsersRequest;
import com.example.advertisinganalizator.io.repo.ClickRepo;
import com.example.advertisinganalizator.io.repo.ImpressionRepo;
import com.example.advertisinganalizator.io.repo.UsersRequestRepo;
import com.example.advertisinganalizator.service.LoadCSVFilesService;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
public class LoadCSVFilesServiceImpl implements LoadCSVFilesService {

    private final UsersRequestRepo usersRequestRepo;
    private final ClickRepo clickRepo;
    private final ImpressionRepo impressionRepo;

    @Autowired
    public LoadCSVFilesServiceImpl(UsersRequestRepo usersRequestRepo, ClickRepo clickRepo, ImpressionRepo impressionRepo) {
        this.usersRequestRepo = usersRequestRepo;
        this.clickRepo = clickRepo;
        this.impressionRepo = impressionRepo;
    }

    @Override
    public int loadUsersRequestsFiles(String fileName) {
        AtomicInteger res = new AtomicInteger();
        try(Reader reader = Files.newBufferedReader(Paths.get(fileName));
            CSVReader csvReader = new CSVReader(reader)) {

            String[] record;
            while ((record = csvReader.readNext()) != null) {
                UsersRequest usersRequest = UsersRequest.builder()
                        .epochTimestamp(record[0])
                        .sessionId(record[1])
                        .partner(record[2])
                        .userId(record[3])
                        .bid(Double.valueOf(record[4]))
                        .isWin(Boolean.valueOf(record[5]))
                        .build();

                usersRequestRepo.save(usersRequest);
                res.incrementAndGet();
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return res.get();
    }

    @Override
    public int loadClicksFiles(String fileName) {
        AtomicInteger res = new AtomicInteger();
        try(Reader reader = Files.newBufferedReader(Paths.get(fileName));
            CSVReader csvReader = new CSVReader(reader)) {

            String[] record;
            while ((record = csvReader.readNext()) != null) {
                Click click = Click.builder()
                        .epochTimestamp(record[0])
                        .sessionId(record[1])
                        .timePass(Integer.valueOf(record[2]))
                        .build();

                clickRepo.save(click);
                res.incrementAndGet();
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return res.get();
    }

    @Override
    public int loadImpressionsFiles(String fileName) {
        AtomicInteger res = new AtomicInteger();
        try(Reader reader = Files.newBufferedReader(Paths.get(fileName));
            CSVReader csvReader = new CSVReader(reader)) {

            String[] record;
            while ((record = csvReader.readNext()) != null) {
                Impression impression = Impression.builder()
                        .epochTimestamp(record[0])
                        .sessionId(record[1])
                        .duration(Integer.valueOf(record[2]))
                        .build();

                impressionRepo.save(impression);
                res.incrementAndGet();
            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return res.get();
    }
}
