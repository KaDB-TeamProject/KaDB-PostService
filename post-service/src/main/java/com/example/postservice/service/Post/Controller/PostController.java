package com.example.postservice.service.Post.Controller;

import com.example.postservice.service.Post.Entity.Post;
import com.example.postservice.service.Post.Repository.PostRepository;
import com.example.postservice.service.Post.Dto.Request.PostRequestDto;
import com.example.postservice.service.Post.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
// ResponseBdoy를 사용하면 ViewResolver 사용 안함, 대신 HTTP의 BODY에 문자 내용 직접 반환(return)
// ViewResolver : 컨트롤러에서 반환한 리턴 값에 해당하는 화면을 찾는다.
public class PostController {
    private final PostService postService;
    private final PostRepository postRepository;
    // 새로운 post 등록
    @PostMapping("/newpost")
    public void newPost(@ModelAttribute PostRequestDto postRequestDto) throws IOException {
        postService.savePost(postRequestDto);
    }
    @PostMapping("/editpost/{id}")
    public void editPost(@ModelAttribute PostRequestDto postRequestDto,@PathVariable("id") long id) throws IOException{
        postService.savePost(postRequestDto,id);
    }
    @GetMapping("/delete")
    public void deletePost(@RequestParam Long id) throws IOException{
        postService.deletePost(id);
    }
    @GetMapping("/getpost/{id}")
    public Post getPost(@PathVariable Long id){
        return postService.getPost(id);
    }
    @GetMapping("/getpost/all")
    public List<Post> getallPost(){
        return postService.getAllPost();
    }
}
