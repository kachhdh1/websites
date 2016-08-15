package com.dvk.advice;

import org.aspectj.lang.ProceedingJoinPoint;


public class PerformanceTimingAdvice {
	
	
	private static final int NANOSECONDS_IN_A_MILLISECONDS = 1000000;

	public Object performanceTimingMeasurement(ProceedingJoinPoint method) throws Throwable{
		long before = System.nanoTime();
		
		Object returnValue = method.proceed();
		
		long after = System.nanoTime();
		long timeTaken = (after-before)/NANOSECONDS_IN_A_MILLISECONDS;
		System.out.println("The method "+method.getSignature().getName()+
				" took "+timeTaken);
		
		return returnValue;
	}

}
