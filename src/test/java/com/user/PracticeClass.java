package com.user;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.base.BaseClass;

public class PracticeClass extends BaseClass{

	@Test
	public void mothod1() {
		driver.get("chrome://chrome-urls/");
		System.out.println("test");
	//	Assert.fail();
		
		}
}
