package com.example.postservice.repository;

import com.example.postservice.Entity.schedule.Images;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepository extends JpaRepository<Images,Long> {
}
