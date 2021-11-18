package com.example.advertisinganalizator.io.repo;

import com.example.advertisinganalizator.io.entity.UsersRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRequestRepo extends JpaRepository<UsersRequest, Long> {

    //TODO need additional functionality for choose by user_id, no need to return all columns
}
