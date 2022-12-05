# Author: Juan Felipe Velasco García
# Language: EN

  Feature: as user of Falabella web page, i need to add three items to the shopping cart and validate the price

    Background: Go to Falabella homepage
      Given the user go to the homepage

    Scenario: Add item to shopping cart
      When select the three items
      Then verify the shopping cart total
