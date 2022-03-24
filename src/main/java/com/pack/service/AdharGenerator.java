package com.pack.service;

import java.util.Random;

import org.springframework.stereotype.Component;
@Component
public class AdharGenerator {
	
	public Integer generate() {
		Random random=new Random();
		Integer myvalue=random.nextInt(10000);
		return 1000000+myvalue;
	}

}
