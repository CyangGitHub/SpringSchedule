package com.example;

import com.example.module.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootMultiDataSourceApplication.class)
public class SpringBootMultiDataSourceApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	UserService userService;


	@Test
	public void testMysql(){
		List allMysql = userService.getAllMysql();
		System.out.println(allMysql);
		List alloracle = userService.getAlloracle();
		System.out.println(alloracle);

	}


}
