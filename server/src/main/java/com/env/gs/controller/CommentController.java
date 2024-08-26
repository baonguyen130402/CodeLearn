package com.env.gs.controller;

import com.env.gs.request.CommentRequest;
import com.env.gs.service.CommentService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v3/comment/")
@Tag(name = "Comment_API")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping()
    public ResponseEntity<?> createComment(CommentRequest request){
        return ResponseEntity.ok(commentService.addComment(request));
    }

    @GetMapping("post/{id}")
    public ResponseEntity<?> getAllCommentByPostId(@PathVariable  Integer id){
        return ResponseEntity.ok(commentService.getAllByPostId(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getAllComment(@PathVariable Integer id){
        return ResponseEntity.ok(commentService.getById(id));
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateComment(CommentRequest request , @PathVariable Integer id){
        return ResponseEntity.ok(commentService.updateComment(request,id));
    }
}
