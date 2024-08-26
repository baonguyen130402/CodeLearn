package com.env.gs.controller;

import com.env.gs.domain.Post;
import com.env.gs.request.PostRequest;
import com.env.gs.service.PostService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v3/post")
@Tag(name = "Post_API")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public ResponseEntity<List<Post>> getAllPost(){
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Post> getById(Integer id){
        return ResponseEntity.ok(postService.getById(id));
    }

    @PostMapping()
    public ResponseEntity<Post> addPost(PostRequest request){
        return ResponseEntity.ok(postService.addPost(request));
    }
}
