package com.env.gs.repository;

import com.env.gs.domain.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends MongoRepository<Comment, Integer> {

    @Query("{ 'PostId' : ?0 }")
    List<Comment> getCommentByPostId(Integer postId);
}
