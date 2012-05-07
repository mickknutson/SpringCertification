Scenario: When a token is encoded, it should result in an md5 encrypted String.
Given a token
When the token is encoded
Then the resulting value should be md5 encoded