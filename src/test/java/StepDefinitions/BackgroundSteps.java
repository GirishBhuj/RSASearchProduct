package StepDefinitions;

import io.cucumber.java.en.*;

public class BackgroundSteps
{	
	@Given("User opens the login page")
	public void user_opens_the_login_page() throws InterruptedException
	{
		System.out.println("Checkout feature Background Given");
	}

	@When("User enters username and password")
	public void user_enters_username_and_password() throws InterruptedException
	{
		System.out.println("Checkout feature Background When");
	}

	@Then("Home page is displayed")
	public void home_page_displayed() throws InterruptedException
	{
		System.out.println("Checkout feature Background Then");
	}
	
	// -----------------------------------------------
	@Given("User opens the login page of product search")
	public void user_opens_product_search_login_page() throws InterruptedException
	{
		System.out.println("Product search feature Background  Given");
	}

	@When("User enters username and password for product search")
	public void user_enters_username_and_password_on_prod_search() throws InterruptedException
	{
		System.out.println("Product search feature Background when");
	}

	@Then("Home page is displayed of product search")
	public void prod_serch_page_displayed() throws InterruptedException
	{
		System.out.println("Product search feature Background Then");
	}	
}