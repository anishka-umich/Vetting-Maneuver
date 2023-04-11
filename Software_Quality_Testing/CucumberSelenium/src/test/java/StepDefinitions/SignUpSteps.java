package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

public class SignUpSteps {
    WebDriver driver = null;
    WebDriverWait wait = null;
    String projectPath = System.getProperty("user.dir");



    @Given("user is on Sign Up page")
    public void user_is_on_Sign_UP_page(){
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));


        driver.navigate().to("http://localhost:4200");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-navigation/nav/div/div[2]/a[3]")));
        driver.findElement(By.xpath("/html/body/app-root/div/app-navigation/nav/div/div[2]/a[3]")).click();
    }
    
    @When("user enters Email, Name, password, phone, and address")
    public void user_enters_email_name_password_phone_and_address() {
    	// Enter email
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-signup/div/form/div[1]/input")));
        driver.findElement(By.xpath("/html/body/app-root/div/app-signup/div/form/div[1]/input")).sendKeys("pop345@email.com");
        
        // Enter name
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-signup/div/form/div[2]/input")));
        driver.findElement(By.xpath("/html/body/app-root/div/app-signup/div/form/div[2]/input")).sendKeys("peter pop");
        
        // Enter password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-signup/div/form/div[3]/input")));
        driver.findElement(By.xpath("/html/body/app-root/div/app-signup/div/form/div[3]/input")).sendKeys("1234");
        
        // Enter phone
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-signup/div/form/div[4]/input")));
        driver.findElement(By.xpath("/html/body/app-root/div/app-signup/div/form/div[4]/input")).sendKeys("3138765456");
        
        // Enter address
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-signup/div/form/div[5]/input")));
        driver.findElement(By.xpath("/html/body/app-root/div/app-signup/div/form/div[5]/input")).sendKeys("765 counter dr");
    }
  
    @And("clicks on Sign Up button")
            public void clicks_on_Sign_Up_button() throws InterruptedException{
        // Click sign up
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-signup/div/form/div[6]/button")));
        driver.findElement(By.xpath("/html/body/app-root/div/app-signup/div/form/div[6]/button")).click();

    }

    @Then("user is navigated to the log in page")
    public void user_is_navigated_to_the_log_in_page() throws InterruptedException {

        assertTrue(driver.getPageSource().contains("Sign In"));
        Thread.sleep(2000);
        driver.close();
        driver.quit();
    }

}