#Author: nk75319@gmail.com
@tag
Feature: Send Email using gmail
  In order to send the email
  user shoud have an activated gmail account 

  @tag1
  Scenario Outline: Login in to Gmail
    Given User enter the correct email id as '<EmailID>' in the email address field after launching the application
    When User click on the Next button
    And User enter the correct password as '<Password>' in the password field
    And User click on the Next button
    Then User should able to navigate to the inbox page

    Examples: 
      | EmailID           | Password |
      | emailid@gmail.com | xyz      |

  @tag2
  Scenario Outline: Compose and send the mail
    Given User click on the compose button
    And User enters receiptent mail id as '<ReceiptentID>' in the to field
    And User enters receiptent subject as '<Subject>' in the to field
    When User compose the message in the mail body as '<MailBody>' in the to field
    Then User click on the Send button

    Examples: 
      | ReceiptentID | Subject | MailBody |
      | Receiptent@gmail.com        |       subject name | email body |

  @tag3
  Scenario: Logout grom gmail
    Given User click on the profile button
    When User click on the signout button
    Then User should able to navigate to the login page

    
