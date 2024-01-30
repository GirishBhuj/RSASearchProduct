Feature: Place the order for Product

Background: User logged in Checkout feature page
						Given User opens the login page
						When User enters username and password
						Then Home page is displayed

@PlaceOrderTests
Scenario Outline: Search product in Home and Place the order

Given User is on GreenCart Home page
When User search product with Shortname as <VegName> and get the actual name of product
And Added "3" items of selected product to cart
Then User proceeds to Checkout the order and validate <VegName> items in the checkout page
And User enters the promo code and place the order

Examples:
|VegName|
|TOM|