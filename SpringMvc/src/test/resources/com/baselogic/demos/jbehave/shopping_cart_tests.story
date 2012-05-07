Scenario: When a customer adds an item to the shopping cart, the item should be included in the customer's shopping cart.
Given a customer
Given a shopping cart
Given an item
When the customer adds the item to the shopping cart
Then the item must be included in the list of the shoppingcart's entries