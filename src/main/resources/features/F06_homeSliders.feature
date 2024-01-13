@smoke
  Feature: F06_homeSliders | Sliders is clickable on homepage

    Scenario: First slider is clickable on homepage

      Given click on first slider
      Then  verify first product detail is opened


    Scenario: Second slider is clickable on homepage

      Given click on second slider
      Then  verify second product detail is opened