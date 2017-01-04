package com.example.module.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by admin on 2016/11/24.
 */
@Repository
public interface UserMapper {

    List selectAllUser();


}
