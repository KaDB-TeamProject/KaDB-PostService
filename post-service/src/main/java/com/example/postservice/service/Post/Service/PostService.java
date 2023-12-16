package com.example.postservice.service.Post.Service;

import com.example.postservice.service.Post.Dto.Request.*;
import com.example.postservice.service.Post.Entity.*;
import com.example.postservice.service.Post.Repository.*;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
    private void savePostRepositories(Post newPost, PostRequestDto postRequestDto) throws IOException, DataIntegrityViolationException {
        postRepository.save(newPost);
        for (ScheduleRequestDto schedule:postRequestDto.getSchedules()) {
            Schedule newSchedule = schedule.toEntity(newPost);
            newPost.addSchedule(newSchedule);
            scheduleRepository.save(newSchedule);
            for (ParagraphRequestDto paragraph : schedule.getParagraph()) {
                Paragraph newParagraph = paragraph.toEntity(newSchedule);
                newSchedule.addParagraph(newParagraph);
                System.out.println("paragraph save start");
                System.out.println(newParagraph);
                paragraphRepository.save(newParagraph);
                System.out.println("paragraph save end");
                if (paragraph.getTransports()!=null) {
                    for (TransportRequestDto transport : paragraph.getTransports()) {
                        Transport newTransport = transport.toEntity(newParagraph);
                        newParagraph.addTransport(newTransport);
                        System.out.println("transport save start");
                        transportRepository.save(newTransport);
                        System.out.println("transport save end");
                    }
                }
                if(paragraph.getImages()!=null) {
                    for (MultipartFile image : paragraph.getImages()) {
                        Images newImage = new ImagesRequestDto(fileUpload(image)).toEntity(newParagraph);
                        newParagraph.addImages(newImage);
                        System.out.println("images save start");
                        imagesRepository.save(newImage);
                        System.out.println("images save end");
                    }
                }
            }
        }
    }
    public void savePost(PostRequestDto postRequestDto) throws IOException {
        Post newPost = postRequestDto.toEntity(categoryRepository.findByName(postRequestDto.getCategory()));
        savePostRepositories(newPost,postRequestDto);
    }
    public void savePost(PostRequestDto postRequestDto, Long id) throws IOException {
        Optional<Post> postWrapper = postRepository.findById(id);
        Post editPost = postWrapper.get();
        savePostRepositories(editPost,postRequestDto);
    }
    public void deletePost(Long id){
        postRepository.deleteById(id);
    }
    public Post getPost(Long id){
        Optional<Post> postWrapper = postRepository.findById(id);
        return postWrapper.get();
    }
    public List<Post> getAllPost() {
        List<Post> posts = postRepository.findAll();
        return postRepository.findAll();
    }
}
