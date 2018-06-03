package com.techmentro.beans;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	@Pointcut("execution(* com.techmentro.beans.ABC.a(..))")
	private void methodA() {}
	@Pointcut("execution(* com.techmentro.beans.ABC.b(..))")
	private void methodB() {}
	@Before( "methodA() || methodB()")
	public void doBefore(JoinPoint joinPoint)
	{
		System.out.println("Before advice is applied on "+joinPoint.getSignature().getName()+"() method.");
	}
	
	@AfterReturning(pointcut="methodB()",
			returning="rtValue")
	public void doAfter(JoinPoint joinPoint, String rtValue)
	{
		System.out.println("After advice is applied on "+joinPoint.getSignature().getName()+"() method.");
		System.out.println(rtValue +" is returned by the method.");
	}
	@AfterThrowing(pointcut="execution(* com.techmentro.beans.ABC.c(..))",
			throwing="ex")
	public void doError(JoinPoint joinPoint,Exception ex)
	{
		
		System.out.println("Throws advice is applied on "+joinPoint.getSignature().getName()+"() method.");
		System.out.println("Because of :"+ex);
		
	}
	
	
	
	/*@Around("execution(* com.techmentro.beans.ABC.b(..))")
    public Object aroundProcessing(ProceedingJoinPoint pjp) throws Throwable {
       System.out.println("Around advice is applied.");
        Object retVal = pjp.proceed();
       
        return retVal;
    }*/
}
