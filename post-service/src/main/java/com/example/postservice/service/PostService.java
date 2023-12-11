package com.example.postservice.service;

import com.example.postservice.Entity.Category;
import com.example.postservice.Entity.Post;
import com.example.postservice.Entity.Test;
import com.example.postservice.Entity.schedule.Images;
import com.example.postservice.Entity.schedule.Paragraph;
import com.example.postservice.Entity.schedule.Schedule;
import com.example.postservice.Entity.schedule.Transport;
import com.example.postservice.controller.ParagraphForm;
import com.example.postservice.controller.PostForm;
import com.example.postservice.controller.TransportForm;
import com.example.postservice.repository.*;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional
// 수정, 삭제, 저장 기능이 있는 메서드에는 추가로 @Transactional 하는게 효율적
public class PostService{
    private final PostRepository postRepository;
    private final CategoryRepository categoryRepository;
    private final ParagraphRepository paragraphRepository;
    private final ImagesRepository imagesRepository;
    private final TransportRepository transportRepository;
    private final ScheduleRepository scheduleRepository;
    private final EntityManager em;
    private String fileUpload(MultipartFile multipartFile) throws IOException {
        // 파일 저장 경로 설정 : 실제 서비스되는 위치(프로젝트 외부에 저장)
        // 마지막에 / 필요
        String uploadPath = "C:\\Users\\hamer\\saved-images\\";
        // 원본 파일 이름 알아오기
        String originalFileName = multipartFile.getOriginalFilename();
        // 파일 이름이 중복되지 않도록 파일 이름 변경 : 서버에 저장할 이름
        UUID uuid = UUID.randomUUID();
        String savedFileName = uuid.toString() + "_" + originalFileName;
        // 파일 생성
        File newFile = new File(uploadPath + savedFileName);
        multipartFile.transferTo(newFile);
        return savedFileName;
    }
    public Post newPost(PostForm postForm) throws IOException {
        Post post = new Post(
                postForm.getTitle(),
                0,
                0,
                categoryRepository.findCategoryByName(postForm.getCategory())
        );
        Schedule schedule = new Schedule();
        List<ParagraphForm> paragraphForms = postForm.getParagraph();
        for(ParagraphForm e:paragraphForms){
            Paragraph paragraph = new Paragraph(
                    e.getPlace(),
                    e.getAddress(),
                    e.getText(),
                    post,
                    schedule
            );
            List<TransportForm> transportForms = e.getTransports();
            for (MultipartFile f:e.getImages()){
                String imgPath = fileUpload(f);
                Images images = new Images(
                        paragraph,
                        imgPath
                );
                imagesRepository.save(images);
            }
            paragraphRepository.save(paragraph);
            for(TransportForm t:transportForms){
                Transport transport = new Transport(
                        t.getTransport(),
                        t.getTransportName(),
                        t.getTime(),
                        t.getMoney(),
                        paragraph
                );
                transportRepository.save(transport);
            }
        }
        postRepository.save(post);
        scheduleRepository.save(schedule);
        return post;
    }
    public Post editPost(PostForm postForm, HttpServletRequest request) throws IOException{
    }
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
    public Optional<Post> getPost(Long id){
        return postRepository.findById(id);
    }
    public List<Post> getAllPost() { return postRepository.findAll(); }
}
