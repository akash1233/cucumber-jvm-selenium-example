package com.michalvich.cucumber.selenium.example;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;
import static org.junit.Assert.assertTrue;

public class GoogleSearchScenario {
    private RemoteWebDriver driver;

	@Given("^the page is open \"([^\"]*)\"$")
	public void the_page_is_open(String page) throws Throwable {
		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
		capability.setJavascriptEnabled(true);
		capability.setPlatform(Platform.VISTA);
		driver = new RemoteWebDriver(new URL("http://100.72.242.8:4444/wd/hub"), capability);
		driver.get(page);
	}

	@When("^I search for \"([^\"]*)\"$")
	public void I_search_for(String search) throws Throwable {
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys(search);
		element.submit();
	}

	@Then("^a browser title should contains \"([^\"]*)\"$")
	public void a_browser_title_should_contains(String text) throws Throwable {
		assertTrue(driver.getTitle().contains(text));
		driver.close();
		driver.quit();
	}

}
