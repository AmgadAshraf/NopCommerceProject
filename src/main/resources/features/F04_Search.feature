@smoke
  Feature: F04_Search | user can use the search feature


    Scenario Outline: user can search using product name
      Given user enter product "<name>" in search bar and click search button
      Then  "<name>" products are displayed on webpage

      Examples:
      | name |
      | book |
      | laptop |
      | nike   |


    Scenario Outline: user can search using sku
      Given user enter product "<sku>" in search bar and click search button
      Then  "<sku>" products are displayed on webpages

      Examples:
      | sku |
      | SCI_FAITH |
      | APPLE_CAM |
      | SF_PRO_11 |
