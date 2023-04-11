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

public class ManagerViewOrdersSteps {
	WebDriver driver = null;
	WebDriverWait wait = null;
	String projectPath = System.getProperty("user.dir");

	
	@Given("manager user is logged in")
	public void manager_user_is_logged_in() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		driver.navigate().to("http://localhost:4200/login");
		
		// Enter email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[1]/input")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[1]/input")).sendKeys("manager1@email.com");
		Thread.sleep(2000);
		
		// Enter password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[2]/input")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[2]/input")).sendKeys("123");
		
		// Click login
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[4]/button")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[4]/button")).click();
	}

	@When("manager user clicks orders")
	public void manager_user_clicks_orders() throws InterruptedException{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-navigation/nav/div/div/a[1]")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-navigation/nav/div/div/a[1]")).click();
		Thread.sleep(2000);
	}

	@Then("manager user is navigated to the orders page")
	public void manager_user_is_navigated_to_the_orders_page(){
		assertTrue(driver.getPageSource().contains("Orders"));
		driver.close();
		driver.quit();
	}
}
