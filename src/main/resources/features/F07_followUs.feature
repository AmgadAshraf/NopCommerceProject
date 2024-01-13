@smoke
  Feature: F07_followUs | users could open followUs links

    Scenario: user opens facebook link
      Given user click on facebook icon
      Then  facebook website is opened in new tab

    Scenario: user opens twitter link
      Given user opens twitter link
      Then  twitter website is opened in new tab

    Scenario: user opens rss link
      Given user opens rss link
      Then rss link is opened in new tab

   Scenario: user opens youtube link
     Given user opens youtube link
      Then youtube link is opened in new tab