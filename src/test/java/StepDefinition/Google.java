package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Google {

	WebDriver driver;
	
	
	@Given("Google page is open")
	public void google_page_is_open() {
		EdgeOptions options = new EdgeOptions();
	    options.addArguments("--remote-allow-origins=*");
	    driver = new EdgeDriver(options);
	    driver.get("https://www.google.com/");
	    driver.manage().window().maximize();
	}

	@When("^User enters a (.*) in search text box$")
	public void user_enters_a_text_in_search_text_box(String str) throws InterruptedException {
	    driver.findElement(By.name("q")).sendKeys(str);
	    Thread.sleep(1000);
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
	   driver.findElement(By.name("btnK")).click();
	   Thread.sleep(2000);
	}

	@Then("Close the browser")
	public void close_the_browser() {
	  driver.close();
	}
}
