package numaid.testproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Validations {
    RemoteWebDriver driver;
    SoftAssert sa;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        sa = new SoftAssert(); // Initialize SoftAssert here
    }

    @Test
    public void method1() throws Exception {
        openHomePage();
        navigateToJobDetails();
        verifyPageTitle();
        clickInterestedButton();
        scrollPageDown();
        selectGender("Ms.");
        fillBasicInfo("Shakeela", "Shaik", "skshakeela2306@gmail.com", "7032669998");
        fillAddress("Gardens", "Guntur", "AndhraPradesh", "123456", "India");
        fillProfessionalDetails("ABCSolutions", "Fresher", "123456", "789456");
        fillEducationalDetails();
        fillExperienceDetails();
        fillSocialDetails("www.linkedin.com/in/", "C:\\Users\\sksha\\Documents\\Resume.txt");
        submitApplication();

        // Perform Soft Assertions for all verifications
        sa.assertAll();
    }

    private void openHomePage() {
        driver.get("https://jobs.numadic.com/jobs/Careers");
    }

    private void navigateToJobDetails() 
    {
    	if(driver.findElement(By.xpath("//h2[text()='JOIN OUR CREW']")).isDisplayed())
		{
			 driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
	    }
    }

    private void verifyPageTitle() {
        String expectedTitle = "Numadic Iot Pvt. Ltd. - QA Engineer in";
        String actualTitle = driver.getTitle();
        sa.assertEquals(actualTitle, expectedTitle, "Page title mismatch");
    }

    private void clickInterestedButton() {
        driver.findElement(By.xpath("//lyte-yield[text()=\"I'm interested\"]")).click();
        Reporter.log("\nClicked on 'I'm interested' button\n");
    }

    private void scrollPageDown() throws Exception {
        driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
        Thread.sleep(2000);
    }

    private void selectGender(String gender) {
        driver.findElement(By.xpath("(//span[text()='-None-'])[1]")).click();
        WebElement element = driver.findElement(By.xpath("//lyte-drop-item[@data-value='" + gender + "']"));
        element.click();
        String actualSelectedValue = element.getAttribute("data-value");
        sa.assertEquals(actualSelectedValue, gender, "Selected gender mismatch");
    }

    private void fillBasicInfo(String firstName, String lastName, String email, String phoneNumber) 
    {
    	driver.findElement(By.xpath("//input[@class='cxBorderBottom ']")).sendKeys("Shakeela",Keys.TAB,"Shaik",Keys.TAB,"skshakeela2306@gmail.com",Keys.TAB,"7032669998");
		   
        // ... validate using SoftAssert ...
    }

    private void fillAddress(String address, String city, String state, String zip, String country) {
    	driver.findElement(By.xpath("(//input[contains(@type,'text')])[5]")).sendKeys("Gardens",Keys.TAB,"Guntur",Keys.TAB,"AndhraPradesh",Keys.TAB,"123456", Keys.TAB,"India");
        // ... validate using SoftAssert ...
    }

    private void fillProfessionalDetails(String company, String experience, String skills, String salary) {
    	driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("ABCSolutions");
		driver.findElement(By.tagName("body")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.xpath("(//span[text()='-None-'])[2]")).click();
		driver.findElement(By.xpath("//lyte-drop-item[@data-value='Fresher']")).click();
		driver.findElement(By.xpath("(//input[contains(@type,'text')])[11]")).sendKeys("123456", Keys.TAB,"789456");
		
        // ... validate using SoftAssert ...
    }

    private void fillNoticePeriod(String noticePeriod) {
        // ... perform action to fill notice period ...
        // ... validate using SoftAssert ...
    }

    private void fillEducationalDetails() {
        // ... perform action to fill educational details ...
        // ... validate using SoftAssert ...
    }

    private void fillExperienceDetails() {
        // ... perform action to fill experience details ...
        // ... validate using SoftAssert ...
    }

    private void fillSocialDetails(String linkedInProfile, String resumeFilePath) {
        // ... perform action to fill social details ...
        // ... validate using SoftAssert ...
    }

    private void submitApplication() {
        driver.findElement(By.xpath("//lyte-yield[normalize-space()='Submit Application']")).click();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
