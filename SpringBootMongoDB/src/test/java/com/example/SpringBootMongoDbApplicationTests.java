package com.example;

import com.example.moudel.dao.UserRepository;
import com.example.moudel.dao.WebLogRepository;
import com.example.moudel.entity.User;
import com.example.moudel.entity.WebLog;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

//@RunWith(SpringRunner.class)
//@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpringBootMongoDbApplication.class)
public class SpringBootMongoDbApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	WebLogRepository webLogRepository;
/*	@Autowired
	private UserRepository userRepository;
	@Before
	public void setUp() {
		userRepository.deleteAll();
	}*/
/*	@Test
	public void test() throws Exception {
		System.out.println(userRepository.count());

	}*/
	@Test
	public void testMongo1(){
        WebLog byUrl = webLogRepository.findByUrl("http://localhost:10011/test");
        System.out.println(byUrl);
    }
}
