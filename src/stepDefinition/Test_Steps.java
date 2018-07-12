package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

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
		String baseUrl = "https://www.junoemr.com/harsh_jain";
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

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
        //Get web element for username, password and pin
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement pin = driver.findElement(By.id("pin"));
        
        //Enter values for the web element
        username.sendKeys("harsh_jain");
        password.sendKeys("zcprqswge");
        pin.sendKeys("6275");
        
        //Click on login button
        WebElement submit = driver.findElement(By.name("commit"));
        submit.click();
	}

	@Then("^User can now view the HomePage$")
	public void user_can_now_view_the_HomePage() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
        
        if(driver.findElement(By.id("oscar_aged_consults")).isDisplayed()==true){
            System.out.println("Test2 Passed!");
        } else {
            System.out.println("Test Failed");
        
        }
	}

}
