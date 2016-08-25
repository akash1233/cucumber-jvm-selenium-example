Drone.io Build status

[![Build Status](https://drone.io/github.com/akash1233/cucumber-jvm-selenium-example/status.png)](https://drone.io/github.com/akash1233/cucumber-jvm-selenium-example/latest)

Saucelabs build status 

[![Sauce Test Status](https://saucelabs.com/buildstatus/dharmendrasingh)](https://saucelabs.com/u/dharmendrasingh)

Circle CI Build Status 

[![CircleCI](https://circleci.com/gh/akash1233/cucumber-jvm-selenium-example.svg?style=svg)](https://circleci.com/gh/akash1233/cucumber-jvm-selenium-example)

[![Coverage Status](https://coveralls.io/repos/github/akash1233/cucumber-jvm-selenium-example/badge.svg?branch=master)](https://coveralls.io/github/akash1233/cucumber-jvm-selenium-example?branch=master)

cucumber-jvm-selenium-example
================

This is a simple example how to use [cucumber-jvm](https://github.com/cucumber/cucumber-jvm) in Java
together with [Selenium](http://seleniumhq.org/)

This basic scenario tests search on Google page. It opens [google.com] and search for string "Cucumber".

<pre>
Feature: Search on Google
  As an user
  I want to search on Google
  So that I can see results

  Scenario: results are shown
    Given the page is open "http://www.google.com"
    When I search for "Cucumber"
    Then a browser title should contains "Cucumber"
</pre>
These tests also work with saucleabs cloud .
