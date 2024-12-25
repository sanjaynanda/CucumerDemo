package stepsDefinitions;

import io.cucumber.java.en.*;
import junit.framework.Assert;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Steps {
	
	WebDriver driver;

	@Given("the user is on the nopCommerce login page")
	public void navigateToLoginPage() {
	  
	driver=new ChromeDriver();
	driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//a[normalize-space()='Log in']"));
		
	}

	
	@When("the user enters valid credentials \\(username: {string}, password: {string})")
	public void the_user_enters_valid_credentials_username_password(String user, String pwd) {
	  
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(user);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(pwd);
	}

	@When("the user clicks on the Login button")
	public void the_user_clicks_on_the_login_button() {
	    
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		driver.findElement(By.xpath("//*[@id=\"HJup0\"]/div/label/input")).click();
		
	}

	@Then("the user should be redirected to the My Account Page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
	    
		boolean status=driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed();
		Assert.assertEquals(status,true);
	}

	@Then("the user should see a welcome message")
	public void the_user_should_see_a_welcome_message() {
	  
		boolean welcometxt=driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']")).isDisplayed();
		Assert.assertEquals(welcometxt,true);
		driver.quit();
	}


}
