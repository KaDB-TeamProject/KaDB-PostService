package com.example.postservice.repository;

import com.example.postservice.Entity.schedule.Transport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransportRepository extends JpaRepository<Transport,Long> {
}
