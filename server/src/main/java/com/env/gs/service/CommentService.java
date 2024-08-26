package com.env.gs.service;

import com.env.gs.domain.Comment;
import com.env.gs.request.CommentRequest;

import java.util.List;

public interface CommentService {

    List<Comment> getAllByPostId(Integer postId);
    Comment getById(Integer id);
    Comment addComment(CommentRequest request);
    Comment updateComment(CommentRequest request, Integer id);
    void deleteComment(Integer id);
}
