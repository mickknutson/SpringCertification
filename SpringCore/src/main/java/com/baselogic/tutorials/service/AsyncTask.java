package com.baselogic.tutorials.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * <p>Spring Certification objective: 1.3 Annotations</p>
 *
 * @author Mick Knutson
 * @see <a href="http://springcert.sourceforge.net/core-3/index.html">Objective 1.3 Annotations</a>
 * @see <a href="http://www.baselogic.com">Blog: http://baselogic.com</a>
 * @see <a href="http://linkedin.com/in/mickknutson">LinkedIN: http://linkedin.com/in/mickknutson</a>
 * @see <a href="http://twitter.com/mickknutson">Twitter: http://twitter.com/mickknutson</a>
 * @see <a href="http://github.com/mickknutson">Git hub: http://github.com/mickknutson</a>
 * @see <a href="http://www.packtpub.com/java-ee6-securing-tuning-extending-enterprise-applications-cookbook/book">JavaEE 6 Cookbook Packt</a>
 * @see <a href="http://www.amazon.com/Cookbook-securing-extending-enterprise-applications/dp/1849683166">JavaEE 6 Cookbook Amazon</a>
 * @since 2012
 */
@Service
public class AsyncTask {

    private static final Logger logger = LoggerFactory.getLogger(AsyncTask.class);

    private int count;
    private boolean complete = false;

    @Async
    public void execute(String string, int delay) {
        count++;
        initSleep(delay);
        complete = true;
        logger.info("execute: {}, isComplete: {}", string, complete);
    }

    @Async
    public Future<String> executeReturningFuture(String string, int delay) {
        count++;

//        initSleep(delay);
        try {
            Thread.sleep(delay);
            complete = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        logger.info("executeReturningFuture: {}, isComplete: {}", string, complete);


        return new AsyncResult<String>(string + ":" + count + ":" + delay);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


    private void initSleep(int time) {
        long end = System.currentTimeMillis() + time;
        while (System.currentTimeMillis() < end) {
            // Do nothing here Just time pass.
        }
    }

}
