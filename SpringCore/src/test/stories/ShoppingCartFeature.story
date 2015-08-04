
import com.baselogic.tutorials.domain.Customer
import com.baselogic.tutorials.domain.Item
import com.baselogic.tutorials.domain.Order
import com.baselogic.domain.ShoppingCart

import com.baselogic.domain.Activity


before_each "Init 1", {
	given "a non-Gold level customer", {
	  	customer = new Customer()
	  	customer.firstName = "Mick Knutson"
	 }
}


scenario "Customer Item Ordering" , {

	when "they have one order in their shopping cart", {

		shoppingCart = new ShoppingCart()
		shoppingCart.addItem(new Item("Foo", 91.00, 2))

 	}
 	then "the total price for the order", {
   		shoppingCart.getTotalPrice().shouldBe 91.00

 	}

 	and "there should be one item ordered by Mick", {
   		customer.firstName.shouldBe "Mick Knutson"
   		shoppingCart.getItemCount().shouldBe 1
 	}
}
