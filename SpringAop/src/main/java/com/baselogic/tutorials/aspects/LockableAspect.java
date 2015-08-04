package com.baselogic.tutorials.aspects;


import com.baselogic.tutorials.service.Lockable;
import com.baselogic.tutorials.service.LockableImpl;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LockableAspect {

    private final Logger logger = LoggerFactory.getLogger(LockableAspect.class);

    @DeclareParents(value = "com.baselogic.tutorials.service.OrderService*+",
            defaultImpl = LockableImpl.class)
    public static Lockable mixin;



    @Pointcut("execution(* com.baselogic.tutorials.service.*.placeOrder(..))" +
    "&& @target(com.baselogic.tutorials.service.Lockable)")
    public void isLockable() {}




    @Before("isLockable() && @target(lockable)")
    public void lockable(JoinPoint jp, Lockable lockable) {
        logger.info(">>> ----------------------->>>");
        logger.info(">>> ----------------------->>>");
        logger.info(">>> ----------------------->>>");
        logger.info(">>> ----------------------->>>");
        logger.info(">>> ----------------------->>>");
        logger.info(">>> ----------------------->>>");
//        logger.info(">>> ----- recordUsage ----->>>");
//        logger.info(">>> Parental trackUsage: {}", usageTracked.trackUsage());
//        logger.info(">>> Parental toString: {}", usageTracked.toString());

        String methodName = jp. getStaticPart().getSignature().toShortString();

        if(lockable.matches(methodName)){
            throw new IllegalStateException("error...");
        }

        //interact with the target class...

//        logger.info(">>> ----- recordUsage ----->>>");
    }

}


