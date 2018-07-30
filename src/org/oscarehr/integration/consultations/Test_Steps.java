package org.oscarehr.integration.consultations;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test_Steps {
	public static WebDriver driver;
	@Given("^User starts the browser$")
	public void user_starts_the_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.gecko.driver","/Users/hjain/code/geckodriver");
		driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();	}
	}

	@When("^User Navigate to Login Page$")
	public void user_Navigate_to_Login_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String baseUrl = "https://localhost:8442/oscar";
        String expectedTitle = "Juno EMR Services Client Login";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test1 Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
	}
    @When("^User enters \"(.*)\" and \"(.*)\" and \"(.*)\"$")
	public void user_enters_Username_Password_and_Pin(String username, String password, String pin) 
			throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
        //Get web element for username, password and pin
        WebElement oscarusername = driver.findElement(By.name("username"));
        WebElement oscarpassword = driver.findElement(By.name("password"));
        WebElement oscarpin = driver.findElement(By.name("pin"));
        
        //Enter values for the web element
        oscarusername.sendKeys(username);
        oscarpassword.sendKeys(password);
        oscarpin.sendKeys(pin);
        
        //Click on login button
//        WebElement submit = driver.findElement(By.name("commit"));
//        submit.click();
        oscarpin.sendKeys(Keys.RETURN);
	}

	@Then("^User can now view the HomePage$")
	public void user_can_now_view_the_HomePage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("demographicQuickSearch"))));		
		WebElement consultationUrl = driver.findElement(By.id("demographicQuickSearch"));
		
        if(consultationUrl.isDisplayed()==true){
            System.out.println("Test2 Passed!");
        } else {
            System.out.println("Test Failed");
        
        }
	}

}
