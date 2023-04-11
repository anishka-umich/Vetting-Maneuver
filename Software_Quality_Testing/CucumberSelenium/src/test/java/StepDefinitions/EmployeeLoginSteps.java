package StepDefinitions;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmployeeLoginSteps {
	WebDriver driver = null;
	WebDriverWait wait = null;
	String projectPath = System.getProperty("user.dir");
	


	@Given("employee user is on login page")
	public void employee_user_is_on_login_page() {
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		
		driver.navigate().to("http://localhost:4200/login");
	}

	@When("employee user enters employee1@email.com and {int}")
	public void employee_user_enters_employee1_email_com_and(Integer int1) throws InterruptedException {
		// Enter email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[1]/input")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[1]/input")).sendKeys("employee1@email.com");
		Thread.sleep(2000);
		
		// Enter password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[2]/input")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[2]/input")).sendKeys(String.valueOf(int1));
	}

	@And("clicks login button")
	public void clicks_login_button() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[4]/button")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[4]/button")).click();
	}

	@Then("employee user is navigated to the home page")
	public void employee_user_is_navigated_to_the_home_page() throws InterruptedException {
		Thread.sleep(2000);
		assertTrue(driver.getPageSource().contains("Products"));
		driver.close();
		driver.quit();
	}

	@When("employee user enters manager1@email.com and {int}")
	public void employee_user_enters_manager1_email_com_and(Integer int1) throws InterruptedException {
		// Enter email
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[1]/input")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[1]/input")).sendKeys("manager1@email.com");
		Thread.sleep(2000);
		
		// Enter password
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[2]/input")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[2]/input")).sendKeys(String.valueOf(int1));
	}

}
