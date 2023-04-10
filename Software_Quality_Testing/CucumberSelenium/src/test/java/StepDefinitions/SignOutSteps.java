package StepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignOutSteps {
	WebDriver driver = null;
	WebDriverWait wait = null;
	String projectPath = System.getProperty("user.dir");
	

	
	@Given("user is logged into the application")
	public void user_is_logged_into_the_application() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		// Open the application and log in
		driver.navigate().to("http://localhost:4200/login");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[1]/input")));
		// Enter email
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[1]/input")).sendKeys("employee1@email.com");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[2]/input")));
		// Enter password
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[2]/input")).sendKeys("123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[4]/button")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[4]/button")).click();
		Thread.sleep(2000);
	}

	@When("user clicks Sign Out")
	public void user_clicks_sign_out() {
		// Wait for Sign Out to load and click it
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-navigation/nav/div/div/a[3]")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-navigation/nav/div/div/a[3]")).click();
	
	    
	}

	@Then("user is navigated to the Sign In page")
	public void user_is_navigated_to_the_sign_in_page() throws InterruptedException {
		
		driver.getPageSource().contains("Sign In");
		driver.getPageSource().contains("You have been logged out.");
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}

}
