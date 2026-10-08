@Regression
Feature: Create Lead
As a User
I want to create a new lead
so that the lead is successfully created in the system

@createlead
Scenario Outline: Successfully create a lead with mandatory details
Given User should be able to click Create lead button
Then the create lead page should be displayed
When the User enters the mandatory lead details "<Current Status>","<Loan Type>","<Loan Amount>","<Assign To Agent>" and "<First Name>" 
And the user clicks on save & create lead button
Then user should be able to see the success message as lead created successfully

Examples:
|Current Status|Loan Type|Loan Amount|Assign To Agent|First Name|
|Hot lead      |Car Loan |1200       |Ink Crm        |test1     |
|Warm lead     |Home Loan|1300       |Ink Naushad    |test2     |
