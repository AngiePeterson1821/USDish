Feature: Test Index Page
  Background:
    Given Navigate the browser to: "https://www.usdish.com"

  Scenario: I test the index page of usDish
      #When I navigate to page I check header text
      Then I check hero link url to verify it matches: "https://www.usdish.com/packages"
      #Then I click galentines button
      #Then I verify the url equals: "https://www.usdish.com/galentines-day-movie-marathon-dream-job/"
      Then I check free installation link and verify it matches: "https://www.usdish.com/free-installation"