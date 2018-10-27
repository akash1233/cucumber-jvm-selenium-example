package com.dharma.cucumber.selenium.example;

import cucumber.junit.Cucumber;
import gherkin.formatter.model.Scenario;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(format = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})


public class  GoogleSearchTest {
}


