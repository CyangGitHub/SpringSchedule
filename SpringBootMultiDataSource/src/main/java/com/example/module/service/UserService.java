package com.example.module.service;

import com.example.module.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2016/11/24.
 */
@Service
public class UserService {

    @Autowired
    @Qualifier("mysqlSqlSessionFactory")
    SqlSessionFactory mysqlssf;
    @Autowired
    @Qualifier("oracleSqlSessionFactory")
    SqlSessionFactory oraclessf;
    /**
     *
     * @return
     */

    public List getAllMysql(){
        SqlSession sqlSession = mysqlssf.openSession();
        List<Map> objects = sqlSession.selectList("selectAllUser", UserMapper.class);
        return objects;
    }

    public List getAlloracle(){
        SqlSession sqlSession = oraclessf.openSession();
        List<Map> objects = sqlSession.selectList("selectAllUser", UserMapper.class);
        return objects;
    }

}
