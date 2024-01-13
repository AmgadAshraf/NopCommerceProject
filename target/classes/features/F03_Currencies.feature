@smoke
  Feature: F03_Currencies | user can change currency to euro

    Scenario: guest user can successfully change currency from dollars to euros

      Given user select euro as currency
      Then verify all products price is in euros
