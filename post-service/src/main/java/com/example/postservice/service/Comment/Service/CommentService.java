package com.example.postservice.service.Comment.Service;

import com.example.postservice.service.Comment.Dto.CommentRequestDto;
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

    private Post findPost(Long id){
        return postRepository.findById(id).get();
    }
    public void newComment(CommentRequestDto comment,Long postId){
        Comment newComment = comment.toEntity(findPost(postId));
        commentReposiroty.save(newComment);
    }
    public void editComment(CommentRequestDto comment, Long commentId){
        Comment newComment = commentReposiroty.findById(commentId).get();
        newComment.editComment(comment.getText(),comment.getPost());
        commentReposiroty.save(newComment);
    }
    public List<Comment> getAllComments(Long postId){
        return commentReposiroty.findAllByPost(findPost(postId));
    }
    public void deleteComment(Long commentId){
        commentReposiroty.deleteById(commentId);
    }
}
