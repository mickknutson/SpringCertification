
Objectives:
http://springcert.sourceforge.net/objectives.html


http://springcert.sourceforge.net/index.html

Links to review:
================

http://www.springbyexample.org/examples/spring-jmx.html

http://www.javalobby.org/java/forums/t44746.html

http://static.springsource.org/spring/docs/3.0.0.RC3/reference/html/ch08s05.html
http://static.springsource.org/spring/docs/3.0.0.RC3/reference/html/ch08s05.html

http://www.roseindia.net/tutorial/spring/spring3/aop/proxyfactorybeanexample.html

http://www.jpalace.org/docs/tutorials/spring/beans_16.html



TODO's:
================

* Add Mockito Mock Bean example:

    <bean id="mockDao" class="org.mockito.Mockito" factory-method="mock">
        <constructor-arg value="com.baselogic.OrderDao"/>
    </bean>








* Review EasyB story:


 	then "at the time of checkout, they should receive \$10 off the total price", {
   		customer.checkOut()

   		customer.orderPrice().shouldBe 91.00

 	}
 	
 	and "they should be emailed a coupon within 24 hours", {
   		CouponService.scheduleDiscountEmail(customer)
   		CouponService.scheduledEmails.shouldHave customer
 	}

 	
 	
// The End...
