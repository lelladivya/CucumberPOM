Feature:Login page feature

Scenario:login with valid credentials
Given user is in login page "Account Login"
When user enters valid email id "lelladivya26@gmail.com"
And user enters valid password "Selenium@12345"
And clicks on login button
Then user logged into the application and "My Account" page appears

Scenario Outline:login with invalid credentials
Given user is in login page "Account Login"
When user enters emailid "<email id>"
When user enters password "<password>"
And clicks on login button
Then error message "Warning: No match for E-Mail Address and/or Password." should appear
Examples:
|email id|password|
|leeladivya|12345|
|23445|jahlao|
|divya|Selenium@12345|