package utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

public class AOPUtils {
	
	public static void displayJoinPointDetails(String appendMessage, JoinPoint joinPoint) {
		Signature sign = joinPoint.getSignature();
		System.out.println(appendMessage + " : " + sign.toLongString());
	}

}