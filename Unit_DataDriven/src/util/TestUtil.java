package util;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import assignment.Assessment_Jombay;

public class TestUtil extends Assessment_Jombay {
	public static void doLogin(String username, String password) throws InterruptedException {

		getObject("FirstPgNxtBtn").click();
		Thread.sleep(5000);
		getObject("AssessmentRadioBtn").click();
		getObject("SecondPgNxtBtn").click();
		Thread.sleep(5000);

		String oldTab = driver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		// shift to new tab
		driver.switchTo().window(newTab.get(0));

		Thread.sleep(5000);
		getObject("UserName").sendKeys("QA8");
		getObject("EmailId").sendKeys("QA8@test.com");
		getObject("PhoneNumber").sendKeys("2000000000");
		getObject("SubmitBtn").click();

		Thread.sleep(5000);

		Select collegename = new Select(driver.findElement(By.xpath("(//div/select[@class='custom-select '])[1]")));
		collegename.selectByVisibleText("VJTI");

		driver.findElement(By.xpath("//div/div/label/input[@value='Female']/../span")).click();

		Select city = new Select(driver.findElement(By.xpath("(//div/select[@class='custom-select '])[2]")));
		city.selectByVisibleText("Bengaluru");

		driver.findElement(By.xpath("//div/button[@onclick='return understoodGuidelines(event);']")).click();

		driver.findElement(By.xpath("//div/label/input[@id='check-guidelines']/../span")).click();

		driver.findElement(By.xpath("//div/a[@class='button']")).click();
		Thread.sleep(5000);

//	        try{
//	            String displayedUserName=driver.findElement&amp;amp;amp;amp;amp;lt;/pre&amp;amp;amp;amp;amp;gt;
//	&amp;amp;amp;amp;amp;lt;pre&amp;amp;amp;amp;amp;gt;(By.xpath(OR.getProperty("username_top_link"))).getText();
//	            if(displayedUserName.equals(username)){
//	                isLoggedIn=true;
//	            }else{
//	                isLoggedIn=false;
//	            }
//	        }catch(Throwable t) {
//	           isLoggedIn=false;
	}
}
