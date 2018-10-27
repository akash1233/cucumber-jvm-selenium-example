package com.dharma.cucumber.selenium.example;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import gherkin.formatter.model.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

import static org.junit.Assert.assertTrue;

public class GoogleSearchScenario {
    private RemoteWebDriver driver;
    private static  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    @Given("^the page is open \"([^\"]*)\"$")
    public void the_page_is_open(String page ) throws Throwable {
        //Zalenium
//        desiredCapabilities.setBrowserName("chrome");
//        desiredCapabilities.setCapability("platform", "LINUX");

        ///SL
        desiredCapabilities.setBrowserName("iexplore");
        desiredCapabilities.setCapability("platform", "Windows 10");
//


        desiredCapabilities.setCapability("name" , "TestCase_" + java.util.Calendar.getInstance().getTime().toString());
        desiredCapabilities.setCapability("passed" , true);
        driver = new RemoteWebDriver(
                new URL("https://dharmendrasingh:e21c7bfb-7b48-4334-961f-cebc4078a457@ondemand.saucelabs.com:443/wd/hub"),
                desiredCapabilities);
//        driver = new RemoteWebDriver(
//                new URL("http://localhost:4444/wd/hub"),
//                desiredCapabilities);
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

    @When("^I Click somelink$")
    public void iClickSomelink() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I upload the file$")
    public void iUploadTheFile() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.setFileDetector(new LocalFileDetector());
        driver.findElement(By.name("upfile")).sendKeys("/Users/dharma/IdeaProjects/cucumber-jvm-selenium-example/README.md");
    }

    @Then("^i should be able to add a note$")
    public void iShouldBeAbleToAddANote() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.name("note")).sendKeys("Test");
        driver.findElement(By.cssSelector("[type='submit']")).click();
    }

    @Then("^first link should be \"([^\"]*)\" link$")
    public void firstLinkShouldBeLink(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }


//    private String getFeatureFilename(Scenario scenario) {
//        String featureName = "Feature ";
//        String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
//        featureName = featureName + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
//
//        return featureName;
//    }



}
