#Author: your.email@your.domain.com
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
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Tokio team
  Automated tests for API

  @tag1
  Scenario: I want to check the city field
    When I check the city field

  @tag2
  Scenario: I want to check the conditionID field
    When I check the conditionID field
    
  @tag3
  Scenario: I want to check the condition field
    When I check the condition field
  
  @tag4
  Scenario: I want to check the icon field
    When I check the icon field
    
  @tag5
  Scenario: I want to check the weather object
    When I check the weather object
    
  @tag6
  Scenario: I want to check the description field
    When I check the description field
    
  @tag7
  Scenario: I want to check Sydneys weather date and time
    When I check Sydneys weather date and time