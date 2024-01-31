Feature:  Verify login into the site with valid and invalid data

   Background:
       Given User navigate to the Website

   Scenario: Login as a new sign-up user with valid data
       When User entered a valid credential
           | email| validpassword |
           | qatubeupdate@yopmail.com | 12345 |
       When the user clicks on the sign-in button
       Then Validate the title after login
   Scenario: Login with invalid data by entering an invalid password
       When User entered an invalid credential
           | email | invalidpassword |
           | qatubeupdate@yopmail.com | 123456 |
       When the user clicks on the sign-in button
 Then Error message should display
           | errormessage |
           | Authentication failed |