package com.amazonaws.tests;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import com.amazonaws.pages.AwsCalculatorPage;
import com.prestashop.utilities.TestBaseClass;

public class AWSCalculatorTests extends TestBaseClass {
	
  AwsCalculatorPage calculator = new AwsCalculatorPage();

  @Test(priority=0, description="Monthly bill should be $0.00 by default")
  public void defaultMonthlyBillTest() {
	  assertTrue(calculator.isAt());
	  assertEquals(0.0 ,calculator.getMonthlyBillAmount());
  }
  
  @Test(priority=1)
  public void addedEc2DefaultValuesTest() throws InterruptedException {
	  calculator.addEc2.click();
	  assertTrue(calculator.description.getAttribute("value").isEmpty());
	  assertEquals(calculator.getIntanceCount(),1);
	  assertEquals(Integer.parseInt(calculator.usageCount.getAttribute("value")),100);
	  assertEquals(calculator.getUsageOption(),"% Utilized/Month");
	  //assert that OS -> Linux on t1.micro
	  assertEquals(calculator.ec2Type.getText(),"Linux on t3.2xlarge");
	  //assert that billing option is On-Demand (No Contract)
	  assertEquals(calculator.billingOption.getText(),"On-Demand (No Contract)");
	  //assert that price is 14.64
	  assertEquals(calculator.getMonthlyCost(),243.61);
  }
  
}
