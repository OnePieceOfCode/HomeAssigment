package com.example.advertisinganalizator.io.repo;

import com.example.advertisinganalizator.io.entity.Click;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClickRepo extends JpaRepository<Click, Long> {
}
