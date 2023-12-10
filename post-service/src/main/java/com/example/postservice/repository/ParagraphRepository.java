package com.example.postservice.repository;

import com.example.postservice.Entity.schedule.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParagraphRepository extends JpaRepository<Paragraph,Long> {
}
