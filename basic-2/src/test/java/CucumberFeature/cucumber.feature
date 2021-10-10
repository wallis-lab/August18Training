
Feature: Ampeg Search


Scenario: Search a Product and back home page
Given I am on the home page of the Ampeg website
When I click the product page
And at the product page I click Svt Pro Series
And at the svt pro page click the SVT-3PRO
And click the Home page button
Then close the brower

Scenario: Search a Product detail
Given I am on the home page of the Ampeg website
When I click the product page
And at the product page I click classic Series product
And at the svt pro page click the SVT-410HLF product
Then look the handing weight should "Handling Weight: 85 Pounds"
Then close the brower


