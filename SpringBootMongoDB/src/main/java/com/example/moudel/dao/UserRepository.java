package com.example.moudel.dao;

import com.example.moudel.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by admin on 2016/11/18.
 */
public interface UserRepository extends MongoRepository<User,String> {

    User findByName(String username);

}
