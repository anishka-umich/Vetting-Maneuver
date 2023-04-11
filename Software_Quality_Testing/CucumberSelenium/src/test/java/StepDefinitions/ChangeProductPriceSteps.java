package StepDefinitions;

import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChangeProductPriceSteps {
	WebDriver driver = null;
	WebDriverWait wait = null;
	String projectPath = System.getProperty("user.dir");
	String price;
	Integer newPrice;
	
	@Given("employee user is logged into the application")
	public void employee_user_is_logged_into_the_application() throws InterruptedException {
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

	@When("customer user clicks edit on an item")
	public void customer_user_clicks_edit_on_an_item() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-product/table/tbody/tr[1]/td[8]/a")));
		driver.findElement(By.xpath("/html/body/app-root/div/app-product/table/tbody/tr[1]/td[8]/a")).click();
	}

	@When("enters a new price and clicks submit")
	public void enters_a_new_price_and_clicks_submit() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-product-edit/div/form/div[6]/input")));
		WebElement priceInput = driver.findElement(By.xpath("/html/body/app-root/div/app-product-edit/div/form/div[6]/input"));
		price = priceInput.getAttribute("value");
		priceInput.clear();
		newPrice = Integer.parseInt(price) + 1;
		priceInput.sendKeys(newPrice.toString());
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/app-root/div/app-product-edit/div/form/div[9]/button")).click();
	}

	@Then("user is navigated to Products page showing item with new price")
	public void user_is_navigated_to_products_page_showing_item_with_new_price() throws InterruptedException {
		Thread.sleep(2000);
		driver.getPageSource().contains("Products");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/app-root/div/app-product/table/tbody/tr[1]/td[5]")));
		WebElement productPagePrice = driver.findElement(By.xpath("/html/body/app-root/div/app-product/table/tbody/tr[1]/td[5]"));
		String productPagePriceString = productPagePrice.getText();
		driver.close();
		driver.quit();
		
		assertEquals("$"+newPrice.toString()+ ".00",productPagePriceString);
		
	}
}
