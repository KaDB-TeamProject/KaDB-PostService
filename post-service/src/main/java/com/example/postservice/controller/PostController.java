package com.example.postservice.controller;

import com.example.postservice.Entity.Post;
import com.example.postservice.repository.PostRepository;
import com.example.postservice.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
// ResponseBdoy를 사용하면 ViewResolver 사용 안함, 대신 HTTP의 BODY에 문자 내용 직접 반환(return)
// ViewResolver : 컨트롤러에서 반환한 리턴 값에 해당하는 화면을 찾는다.
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;
    // 새로운 post 등록
    @PostMapping("/newpost")
    public void newpost(@ModelAttribute PostForm postform) throws IOException {
        postService.test(postform);
    }
    @PostMapping("/editpost")
    public void editpost(@ModelAttribute PostForm postForm) throws IOException{

    }
    @PostMapping("/edittest")
    public PostForm edittest(@ModelAttribute PostForm postform) throws IOException {
        System.out.println(postform);
        postService.edittest(postform);
        return postform;
    }
    @GetMapping("/getpost/{id}")
    public Optional<Post> getpost(@PathVariable Long id){
        return postService.getPost(id);
    }
    @GetMapping("/getpost/all")
    public List<Post> getallpost(){
        return postService.getAllPost();
    }
}
