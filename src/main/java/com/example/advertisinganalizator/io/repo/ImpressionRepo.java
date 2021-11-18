package com.example.advertisinganalizator.io.repo;

import com.example.advertisinganalizator.io.entity.Impression;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImpressionRepo extends JpaRepository<Impression, Long> {
}
