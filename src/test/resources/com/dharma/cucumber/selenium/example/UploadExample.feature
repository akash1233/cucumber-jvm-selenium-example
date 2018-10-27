Feature: Upload a file
  As an user
  I want upload a file
  So that I can see results

  Scenario: results are shown
    Given the page is open "https://cgi-lib.berkeley.edu/ex/fup.html"
    When I upload the file
    Then i should be able to add a note