package com.example.moudel.dao;

import com.example.moudel.entity.WebLog;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by admin on 2016/11/18.
 */
public interface WebLogRepository extends MongoRepository<WebLog,String> {

    WebLog findByUrl(String url);

}
