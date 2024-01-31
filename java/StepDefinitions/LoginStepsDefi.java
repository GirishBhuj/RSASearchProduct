package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.testng.Assert.assertEquals;


public class LoginStepsDefi 
{
    private WebDriver driver;

    @Given("User navigate to the Website")
    public void navigateToWebsite()
    {
        // Implement your WebDriver initialization logic here
        // Example using ChromeDriver:
        // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        // driver = new ChromeDriver();
        // driver.get("your_website_url");
    }

    @When("User entered a valid credential")
    public void enterValidCredential(io.cucumber.datatable.DataTable dataTable)
    {
        // Assuming you have input fields with id 'email' and 'password'
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        emailInput.sendKeys(dataTable.cell(1, 0));
        passwordInput.sendKeys(dataTable.cell(1, 1));
    }

    @When("the user clicks on the sign-in button")
    public void clickSignInButton() {
        // Assuming you have a button with id 'sign-in'
        WebElement signInButton = driver.findElement(By.id("sign-in"));
        signInButton.click();
    }

    @Then("Validate the title after login")
    public void validateTitleAfterLogin() {
        // Assuming you have a method to get the current page title
        String pageTitle = driver.getTitle();
        assertEquals("Expected Title", pageTitle);
    }

    @When("User entered an invalid credential")
    public void enterInvalidCredential(io.cucumber.datatable.DataTable dataTable) {
        // Assuming you have input fields with id 'email' and 'password'
        WebElement emailInput = driver.findElement(By.id("email"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        emailInput.sendKeys(dataTable.cell(1, 0));
        passwordInput.sendKeys(dataTable.cell(1, 1));
    }

    /*
    @When("the user clicks on the sign-in button")
    public void clickSignInButtonForInvalidLogin() {
        // Assuming you have a button with id 'sign-in'
        WebElement signInButton = driver.findElement(By.id("sign-in"));
        signInButton.click();
    }
    */

    @Then("Error message should display")
    public void errorMessageShouldDisplay(io.cucumber.datatable.DataTable dataTable) {
        // Assuming you have an element to capture the error message
        WebElement errorMessageElement = driver.findElement(By.id("error-message"));
        String actualErrorMessage = errorMessageElement.getText();
        String expectedErrorMessage = dataTable.cell(1, 0);

        assertEquals(expectedErrorMessage, actualErrorMessage);
    }
}