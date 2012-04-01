package com.baselogic.demos.task;

import java.util.Date;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

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
