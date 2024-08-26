package com.env.gs.service;

import com.env.gs.domain.Post;
import com.env.gs.request.PostRequest;

import java.util.List;

public interface PostService {

    List<Post> getAll();
    Post getById(Integer id);
    Post addPost(PostRequest request);
}
