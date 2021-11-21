package com.example.advertisinganalizator.io.repo;

import com.example.advertisinganalizator.io.entity.Click;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClickRepo extends JpaRepository<Click, Long> {

    @Query(value = "select sum(c.time_pass) from clicks c where c.session_id = :sessionId", nativeQuery=true)
    Optional<Long> countSumTimePassBySessionId(@Param("sessionId") String sessionId);
}
