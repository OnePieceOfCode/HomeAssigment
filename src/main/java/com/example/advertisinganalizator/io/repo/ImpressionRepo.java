package com.example.advertisinganalizator.io.repo;

import com.example.advertisinganalizator.io.entity.Impression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ImpressionRepo extends JpaRepository<Impression, Long> {

    @Query(value = "select sum(i.duration) from impressions i where i.session_id = :sessionId", nativeQuery=true)
    Optional<Long> countSumDurationBySessionId(@Param("sessionId") String sessionId);
}
