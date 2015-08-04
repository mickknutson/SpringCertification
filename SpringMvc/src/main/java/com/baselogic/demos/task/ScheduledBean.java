package com.baselogic.demos.task;

import java.util.Date;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * HibernateConfiguration
 *
 * at_see <a href="http://springcert.sourceforge.net/core-3/index.html">Objectives</a><br>
 *
 * @author Mick Knutson
 * at_see Blog: <a href="http://www.baselogic.com">http://baselogic.com</a><br>
 * at_see LinkedIN: <a href="http://linkedin.com/in/mickknutson">http://linkedin.com/in/mickknutson</a><br>
 * at_see Twitter: <a href="http://twitter.com/mickknutson">http://twitter.com/mickknutson</a><br>
 * at_see Github: <a href="http://github.com/mickknutson">http://github.com/mickknutson</a><br>
 *
 * at_see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a><br>
 * at_see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a><br>
 *
 * @since 2012
 *
 */
@Component
public class ScheduledBean {

	//@Scheduled(fixedDelay = 30000)
	public void runFixedTask() {
		sendAsync("runFixedTask");
		System.out.println("ranFixedTask... at " + new Date().toString());
	}


	//@Scheduled(cron = "10,40,50 * * * * *")
	public void runScheduledTask() {
		System.out.println("runScheduledTask... at " + new Date().toString());
	}


	@Async
	public void sendAsync(String name) {

		System.out.println("Starting async: " + new Date().toString() );

		try {
			Thread.sleep(5000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("completed async: " + new Date().toString());
	}


	// future.
	/*@Async
	public Future<Long> performSomeReallyHairyMath(long input) {

		Long result = getResult(input);

		return new AsyncResult<Long>(result);
	}

	public long getResult(long input) {
		// Thread.sleep(30000);
		return 1234L + input;
	}*/

}
