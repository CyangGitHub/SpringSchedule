package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMainApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testArray() {
		int[] arr = {8,15,2,7,9,0,3,6,4};
		int[] newArr = null;
		int temp ;
		for (int i = 0; i<arr.length;i++){
			if(i==0){
				int gou=arr[i];
				System.out.println(gou);
				newArr[0] = arr[i];
				System.out.println(gou);
				continue;
			}
		}

	}

	public static void main(String[] args){

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=0; i<10; i++){
					System.out.print(i+" ");
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=0; i<10; i++){
					System.out.print(i+" ");
				}
			}
		}).start();
	}

}
