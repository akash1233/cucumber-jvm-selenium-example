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

    @Given("^the page is open \"([^\"]*)\"$")
    public void the_page_is_open(String page) throws Throwable {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setBrowserName(System.getenv("SELENIUM_BROWSER"));
        desiredCapabilities.setVersion(System.getenv("SELENIUM_VERSION"));
        desiredCapabilities.setCapability(CapabilityType.PLATFORM, System.getenv("SELENIUM_PLATFORM"));
        driver = new RemoteWebDriver(
                new URL("http://D_Singh:44c07910-d4a8-4430-8ec6-e31012792bab@ondemand.saucelabs.com:80/wd/hub"),
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
        System.out.println("----------------Title contains " + driver.getTitle() + "----------------------");
        printSessionId();
        assertTrue(driver.getTitle().contains(text));
        driver.close();
        driver.quit();
    }
    private void printSessionId() {
        String message = String.format("SauceOnDemandSessionID=%1$s job-name=%2$s status=%3$s", (((RemoteWebDriver) driver).getSessionId()).toString(), "TestCase1" , "pass");
        System.out.println(message);
    }
}
