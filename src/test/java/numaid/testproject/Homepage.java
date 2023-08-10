package numaid.testproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage 

	{
			RemoteWebDriver driver;
			SoftAssert sa;
		@Test
		public void method1() throws Exception
		{
			
			//Open browser
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			//Maximise browser
			driver.manage().window().maximize();
			//Launch site
			driver.get("https://jobs.numadic.com/jobs/Careers"); 
			Thread.sleep(5000);
			if(driver.findElement(By.xpath("//h2[text()='JOIN OUR CREW']")).isDisplayed())
			{
				 driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		    }
			Thread.sleep(5000);
			driver.findElement(By.xpath("//lyte-icon[@class='dropdown']")).click();
		    driver.findElement(By.xpath("//lyte-drop-item[@id='Lyte_Drop_Item_2']")).click();
		    Thread.sleep(2000);
			driver.findElement(By.xpath("(//a[@class='cw-1-title'])[4]")).click();
			Thread.sleep(3000);
			
			//Verification of Title from page and title given in Assignment document
			   String x = "Numadic Iot Pvt. Ltd. - QA Engineer in";
		        String y = driver.getTitle();
		        Reporter.log("Actual Title: " + y);

		        sa = new SoftAssert();
		        sa.assertEquals(x, y, "Title mismatch");
		        Reporter.log("\nTitle Verification - Assertion Executed\n");
			
			// In this we are having 2 (I'm interested)buttons both navigation to basic info page
			//we can write xpaths using index or using parent child relation, i took common xpath 
			driver.findElement(By.xpath("//lyte-yield[text()=\"I'm interested\"]")).click();
			Reporter.log("\nClicked on 'I'm interested' button\n");
			
			//Scroll page down
			Thread.sleep(3000);
			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(2000);
			
			//Selecting from drop down and Validation
			driver.findElement(By.xpath("(//span[text()='-None-'])[1]")).click();
	        WebElement element = driver.findElement(By.xpath("//lyte-drop-item[@data-value='Ms.']"));
	        element.click();

	        String actualSelectedValue = element.getAttribute("data-value");
	        String expectedSelectedValue = "Ms.";

	        sa.assertEquals(actualSelectedValue, expectedSelectedValue, "Selected value mismatch for first name");
	        			
	        Reporter.log("Both actual and expected values matched for first name\n");

			//filling Basic Info
			driver.findElement(By.xpath("//input[@class='cxBorderBottom ']")).sendKeys("Shakeela",Keys.TAB,"Shaik",Keys.TAB,"skshakeela2306@gmail.com",Keys.TAB,"7032669998");
		   
			//Filling Address Field
			driver.findElement(By.xpath("(//input[contains(@type,'text')])[5]")).sendKeys("Gardens",Keys.TAB,"Guntur",Keys.TAB,"AndhraPradesh",Keys.TAB,"123456", Keys.TAB,"India");
			
		   //Filling Professional details
			driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("ABCSolutions");
			driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.xpath("(//span[text()='-None-'])[2]")).click();
			
			driver.findElement(By.xpath("//lyte-drop-item[@data-value='Fresher']")).click();
			 element.click();

		        String actualSelectedValue1 = element.getAttribute("data-value");
		        String expectedSelectedValue1 = "Fresher";

		        sa.assertEquals(actualSelectedValue1, expectedSelectedValue1, "Selected value mismatch for Current Job");
		        Reporter.log("Both actual and expected values matched for\n");
			
			driver.findElement(By.xpath("(//input[contains(@type,'text')])[11]")).sendKeys("123456", Keys.TAB,"789456");
			
			//leaving notice period field as blank as mentioned in assingment doc.
			driver.findElement(By.xpath("(//input[contains(@type,'text')])[14]")).sendKeys("Enter Sample text", Keys.TAB,"Numaid");
			
			//Educational Details
			//Experience Details
			 driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
			//Social
			driver.findElement(By.xpath("//crux-website-component[@id='rec-form_111222333445']//input[contains(@type,'text')]")).sendKeys("www.linkedin.com/in/");
			WebElement browseButton = driver.findElement(By.xpath("//span[text()='Browse']"));
			browseButton.click();

		        // Provide the local file path to the file input dialog
		        String filePath = "C:\\Users\\sksha\\Documents\\Resume.txt";
		        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
		        fileInput.sendKeys(filePath);
					
			driver.findElement(By.xpath("//lyte-yield[normalize-space()='Submit Application']")).click();
			sa.assertAll();
			driver.quit();
			}
		

	}		
