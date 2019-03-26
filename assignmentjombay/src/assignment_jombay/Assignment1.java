package assignment_jombay;

import java.util.ArrayList;
//import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment1 {

	public static void main(String[] args) throws InterruptedException {

		// for firefox
		// System.setProperty("webdriver.firefox.marionette",
		// "C:\\Users\\meenal\\geckodriver-v0.24.0-win64.exe");
		// WebDriver driver = new FirefoxDriver();

		// driver call
		System.setProperty("webdriver.chrome.driver",
				"C:\\\\Users\\\\meenal\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		Thread.sleep(5000);
		// enter URL
		driver.get("https://assessment.ur-nl.com/companies/3697/walk-ins/e2af17761dfaa58d8d6d7/system_check/");
		Thread.sleep(5000);
		// Welcome page of assessment- click next button
		driver.findElement(By.xpath("//div/a[@class='start_assessment_btn']")).click();
		Thread.sleep(1000);
		// second page of assessment - radio button click
		driver.findElement(By.xpath("//ul/li/div/label/span[@class='checkmark']")).click();
		Thread.sleep(1000);
		// button click for further action
		driver.findElement(By.xpath("//div/a[@id='nextBtn']")).click();
		Thread.sleep(5000);
		// user shifts to new instance
		String oldTab = driver.getWindowHandle();
		ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
		// shift to new tab
		driver.switchTo().window(newTab.get(0));
		// Enter user name, email id and phone number and click on submit button
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div/input[@id='user_name']")).sendKeys("QA4");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/input[@id='user_email']")).sendKeys("QA4@test.com");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//div/input[@id='user_phone']")).sendKeys("1000000000");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// Next page open for further details of user

		Select collegename = new Select(driver.findElement(By.xpath("(//div/select[@class='custom-select '])[1]")));
		collegename.selectByVisibleText("VJTI");

		driver.findElement(By.xpath("//div/div/label/input[@value='Female']/../span")).click();

		Select city = new Select(driver.findElement(By.xpath("(//div/select[@class='custom-select '])[2]")));
		city.selectByVisibleText("Bengaluru");

		driver.findElement(By.xpath("//div/button[@onclick='return understoodGuidelines(event);']")).click();

		driver.findElement(By.xpath("//div/label/input[@id='check-guidelines']/../span")).click();

		driver.findElement(By.xpath("//div/a[@class='button']")).click();
		Thread.sleep(5000);

//		HashMap<String, String> myData = new HashMap<String,String>;
//		myData.put("Criticism is irritating", "Disagree");
//		myData.put("Mistakes in formatting a document are ok, provided the content is good", "Disagree");
//		myData.put("I take up tasks even when I am not required to", "Rarely");
//		myData.put("I would not want to be the only person to be dependent upon for any task", "Disagree");
//		myData.put("I am less likely to be comfortable with frequent changes", "Disagree");
//		myData.put("I overlook errors in my work as long as they are insignificant ones", "Disagree");

		String MyQData[][] = { { "Criticism is irritating", "Disagree" },
				{ "Mistakes in formatting a document are ok, provided the content is good", "Disagree" },
				{ "I take up tasks even when I am not required to", "Rarely" },
				{ "I would not want to be the only person to be dependent upon for any task", "Disagree" },
				{ "I am less likely to be comfortable with frequent changes", "Disagree" },
				{ "I overlook errors in my work as long as they are insignificant ones", "Disagree" },
				{ "I prefer to initiate something only when I am asked to", "Disagree" },
				{ "I would rather be an inconsistent but star performer than being a consistent but not a star performer",
						"Disagree" },
				{ "I prefer to stick to what I know, instead of using new, unproven methods", "Disagree" },
				{ "I would rather finish more number of tasks than perfect a fewer number of tasks", "Disagree" },
				{ "If I am not told to do any new task, I do not start it", "Disagree" },
				{ "It is practically impossible to fulfill all the tasks as per expected schedules", "Disagree" },
				{ "Quality in a task can be achieved without paying attention to the smallest details", "Disagree" },
				{ "I get irritated when I have to change my plans because of others", "Disagree" },
				{ "Whether I complete it or not, I prefer committing to more work as it shows my enthusiasm",
						"Disagree" },
				{ "I introduce new ways of doing things even if my job doesn't require me to do it at all", "Never" },
				{ "I am okay with paying less attention to minute details of a report, as long as it meets the overall broad requirements",
						"Agree" },
				{ "Change is not worth the time and effort invested in it", "Agree" },
				{ "Enthusiastically taking up extra responsibilities is more important than letting them go just because you may not be able to complete them all",
						"Agree" },
				{ "I prefer doing things only when instructed", "Agree" },
				{ "I don't wait for directions to take up tasks", "Disagree" }

		};

		int totalQ = MyQData.length;

		for (int pageCnt = 0; pageCnt < 14; pageCnt++) {

			for (int j = 0; j < 2; j++) {
				for (int i = 0; i < totalQ; i++) {
					try {
						driver.findElement(By.xpath("//div[contains(text(),'" + MyQData[i][0]
								+ "')]/../../div/ul/li/label[(text()='" + MyQData[i][1] + "')]")).click();
						MyQData[i][0] = null;
						break;
					} catch (Exception e) {
						System.out.println("question not found ");
					}
				}
			}

			// page 12

			// page 13

			// click on next button

		}

		driver.findElement(
				By.xpath("//div[contains(text(),'I get irritated when I have to change my plans because of others')]"))
				.isDisplayed();

	}
}
