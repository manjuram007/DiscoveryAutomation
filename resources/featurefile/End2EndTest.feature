#Author: Manju
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
##
Feature: Video Validation for Discovery.com
Description: Addition of recommended videos to favorites list and its validation

@videovalidation
  Scenario: User is able to validate video title and description 
    Given User navigate to Discovery home page
    Then Scroll to Recommened For You section
    And Hover on video and Click on Add to Favorites plus Button
    When User navigate to my-videos page
   	Then Search for Favorite Shows title
   	Then Validate videos appear with the correct show title and description