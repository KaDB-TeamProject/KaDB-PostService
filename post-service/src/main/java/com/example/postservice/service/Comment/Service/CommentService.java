package com.example.postservice.service.Comment.Service;

import com.example.postservice.service.Comment.Entity.Comment;
import com.example.postservice.service.Comment.Repository.CommentReposiroty;
import com.example.postservice.service.Post.Entity.Post;
import com.example.postservice.service.Post.Repository.PostRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentService {
    private final PostRepository postRepository;
    private final CommentReposiroty commentReposiroty;

    private List<Comment> getAllComments(Long id){
        return commentReposiroty.findAllByPost(postRepository.findById(id).get());
    }
}
