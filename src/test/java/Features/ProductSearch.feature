Feature: Search and place order for Products

Background: User logged in Product search page
						Given User opens the login page of product search
						When User enters username and password for product search
						Then Home page is displayed of product search


@SearchProductTests
Scenario Outline: Search product in Home and Offers page

Given User is on GreenCart Home page
When User search product with Shortname as <VegName> and get the actual name of product
Then User search product with Shortname as <VegName> in Offers page
And Same product displayed in Offers page
Examples:
|VegName|
|TOM|
|Beet|