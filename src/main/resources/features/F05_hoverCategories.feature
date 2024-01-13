@smoke
Feature: F05_hover | user can use the hover feature

  Scenario: user can use the hover feature
    Given user select a random category or sub-category and hover over it
    Then  user verify category or sub-category title is equal to the category or sub-category selected
