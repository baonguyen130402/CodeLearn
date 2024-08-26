package com.env.gs.service.implementation;

import com.env.gs.domain.Post;
import com.env.gs.repository.PostRepository;
import com.env.gs.request.PostRequest;
import com.env.gs.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public List<Post> getAll() {
        return postRepository.findAll();
    }

    @Override
    public Post getById(Integer id) {
        return postRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Post addPost(PostRequest request) {
        Post post = new Post();
        Random random = new Random();
        UUID id = UUID.randomUUID();

        post.setPostId(id.toString());
        post.setThumbnailUrl(request.getThumbnailUrl());
        post.setUserId(request.getUserId());
        post.setDesc(request.getDesc());
        post.setTitle(request.getTitle());
        post.setThumbnailUrl(request.getThumbnailUrl());
        post.setHashtag(request.getHashtag());
        return postRepository.save(post);
    }
}
