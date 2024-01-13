@smoke

  Feature: F08_Wishlist | user can add products to wishlist

    Scenario: user adds product to wishlist
      Given user clicks on wishlist button of a product
      Then  verify success message appeared


    Scenario:  user checks product is in wishlist tab
      Given user adds product to wishlist and opens wishlist tab
      Then  verify product is in the wishlist tab