package com.env.gs.service.implementation;

import com.env.gs.domain.Comment;
import com.env.gs.repository.CommentRepository;
import com.env.gs.request.CommentRequest;
import com.env.gs.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllByPostId(Integer postId) {
        return commentRepository.getCommentByPostId(postId);
    }

    @Override
    public Comment getById(Integer id) {
        return commentRepository.findById(id).orElseThrow();
    }

    @Override
    public Comment addComment(CommentRequest request) {
        Comment comment = new Comment();
        Random random = new Random();
        int id = random.nextInt();

        comment.setCommentId(id);
        comment.setUserid(request.getUserid());
        comment.setPostId(request.getPostId());
        comment.setContent(request.getContent());
        comment.setUpdateDate(request.getUpdateDate());
        comment.setCreateDate(request.getCreateDate());
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(CommentRequest request, Integer id) {
        Comment comment = commentRepository.findById(id).orElseThrow();

        comment.setUserid(request.getUserid());
        comment.setPostId(request.getPostId());
        comment.setContent(request.getContent());
        comment.setUpdateDate(request.getUpdateDate());
        comment.setCreateDate(request.getCreateDate());
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(Integer id) {
        commentRepository.deleteById(id);
    }
}
