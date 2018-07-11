package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
public class MyClass {


    public static void main(String[] args) {
        // declaration and instantiation of objects/variables
    	System.setProperty("webdriver.gecko.driver","/Users/hjain/code/geckodriver");
		WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://www.junoemr.com/harsh_jain";
        String expectedTitle = "Juno EMR Services Client Login";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();	

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test1 Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
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
        
        if(driver.findElement(By.id("oscar_aged_consults")).isDisplayed()==true){
            System.out.println("Test2 Passed!");
        } else {
            System.out.println("Test Failed");
        
        }
         
        
        //Click on Administration Panel
        driver.findElement(By.linkText("Administration")).click();
        
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        
        String[] elements = {"adminNav", "collapseOne", "collapseSixteen","dynamic-content"};
        
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("adminNav"))));

        for (String x:elements) {
        if(driver.findElement(By.id(x)).isDisplayed()==true){
            System.out.println("Test3 Passed!");
        } else {
            System.out.println("Test Failed");
        
        }
        }
       
      //close Fire fox
//        driver.close();
        

    }

}
