package com.example.postservice.service.Post.Repository;

import com.example.postservice.service.Post.Entity.Paragraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParagraphRepository extends JpaRepository<Paragraph,Long> {
}
