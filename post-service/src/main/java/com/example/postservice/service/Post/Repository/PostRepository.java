package com.example.postservice.service.Post.Repository;

import com.example.postservice.service.Post.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
