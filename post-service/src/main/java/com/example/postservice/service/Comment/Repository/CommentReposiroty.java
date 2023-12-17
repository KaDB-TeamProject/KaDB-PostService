package com.example.postservice.service.Comment.Repository;

import com.example.postservice.service.Comment.Entity.Comment;
import com.example.postservice.service.Post.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentReposiroty extends JpaRepository<Comment,Long> {
    List<Comment> findAllByPost(Post post);
}
