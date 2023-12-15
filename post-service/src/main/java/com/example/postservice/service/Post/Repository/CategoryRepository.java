package com.example.postservice.service.Post.Repository;

import com.example.postservice.service.Post.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
}
