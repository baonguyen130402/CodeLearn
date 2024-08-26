package com.env.gs.repository;

import com.env.gs.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User,Integer> {

    @Query("{ 'Email' : ?0 }")
    User getUserByName(String email);

}
