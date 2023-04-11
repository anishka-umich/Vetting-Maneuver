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

public class AddToCartSteps {
	WebDriver driver = null;
	WebDriverWait wait = null;
	String projectPath = System.getProperty("user.dir");
	
	@Given("customer user is logged into the application")
	public void customer_user_is_logged_into_the_application() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		
		// Open the application and log in
		driver.navigate().to("http://localhost:4200/login");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[1]/input")));
		// Enter email
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[1]/input")).sendKeys("customer1@email.com");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[2]/input")));
		// Enter password
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[2]/input")).sendKeys("123");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-login/div/form/div[4]/button")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-login/div/form/div[4]/button")).click();
	
	}

	@When("customer user clicks Get It! button on an item")
	public void customer_user_clicks_get_it_button_on_an_item() {
		// Wait for items to load and click Get It on first one
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-card/div/div[1]/div/div/a")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-card/div/div[1]/div/div/a")).click();
	}

	@When("clicks Add to Cart")
	public void clicks_add_to_cart() {
		// Wait for Add to Cart button to load and click it
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-detail/div/div/div/div/form/button")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-detail/div/div/div/div/form/button")).click();
	}

	@Then("user is navigated to My Cart with appropriate item added")
	public void user_is_navigated_to_my_cart_with_appropriate_item_added() throws InterruptedException {
		assertTrue(driver.getPageSource().contains("Core Java") && driver.getPageSource().contains("My Cart"));
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
}
