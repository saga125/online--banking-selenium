package testNGPractice;


import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

import testNGBankingSystem.BaseClass;

public class PracticeClass1 extends BaseClass{
	
	@Test
	public void mothod1() {
		driver.get("chrome://chrome-urls/");
		System.out.println("test");
		Assert.fail();
		
		}
}
