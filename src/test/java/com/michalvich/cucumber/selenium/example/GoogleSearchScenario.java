package com.michalvich.cucumber.selenium.example;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.Assert.assertTrue;

public class GoogleSearchScenario {
    private RemoteWebDriver driver;
    private static  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    @Given("^the page is open \"([^\"]*)\"$")
    public void the_page_is_open(String page) throws Throwable {
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setVersion("45");
        desiredCapabilities.setCapability("platform", "Windows 8");
        desiredCapabilities.setCapability("name" , "TestCase_1");
        desiredCapabilities.setCapability("passed" , true);
        driver = new RemoteWebDriver(
                new URL("http://dharmendrasingh:e21c7bfb-7b48-4334-961f-cebc4078a457@ondemand.saucelabs.com:80/wd/hub"),
                desiredCapabilities);
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
        System.out.println("----------------Title contain's " + driver.getTitle() + "----------------------");
        printSessionId();
        assertTrue(driver.getTitle().contains(text));
        driver.close();
        driver.quit();
    }
    private void printSessionId() {
        String message = String.format("SauceOnDemandSessionID=%1$s", (((RemoteWebDriver) driver).getSessionId()).toString());
        System.out.println(message);
    }
}
