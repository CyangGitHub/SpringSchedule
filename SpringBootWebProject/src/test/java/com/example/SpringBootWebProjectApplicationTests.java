package com.example;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebProjectApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testChars(){
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);
		System.out.println(uuid.toString().length());
	}

	@Test
	public void testApacheRandom(){
        String random = RandomStringUtils.randomAlphabetic(16);
        String s = RandomStringUtils.randomAlphanumeric(16);
        System.out.println(s);
        System.out.println(random);
    }
}
