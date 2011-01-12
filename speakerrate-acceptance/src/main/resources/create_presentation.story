Scenario: As an Admin, I create a presentation so I can solicit feedback

Given I open the SpeakerRate app
Then I am on the Home page

When I open the Manage Presentations page
And I click "Create new presentation"
Then I am on the New Presentation page

When I enter "Why static methods in Java are really evil" into the Title field
And I enter "1/12/2010" into the Date field
And I click "Submit"
Then I am on the Show Presentation page

When I click "Rate this presentation"
Then I am on the New Rating page




