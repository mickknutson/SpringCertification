Scenario: User fills in CustomerForm

Given user is on Home page
When user opens CustomerForm page
Then CustomerForm page is shown
Then pageLoad is successful within timeout of 10 secs