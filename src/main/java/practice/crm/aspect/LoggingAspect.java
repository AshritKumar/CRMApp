package practice.crm.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	// get Logger
	private Logger myLogger = Logger.getLogger(this.getClass().getName());
	
	@Pointcut("execution(* practice.crm.controller.*.*(..))")
	private void forControllers() {}
	
	@Pointcut("execution(* practice.crm.service.*.*(..))")
	private void forService() {}
	
	@Pointcut("execution(* practice.crm.dao.*.*(..))")
	private void forDAOs() {}
	
	@Pointcut("forControllers() || forService() || forDAOs()")
	private void forAppFlow() {}
	
	// before advice
	@Before("forAppFlow()")
	public void beforeAdvice(JoinPoint jp) {
		myLogger.info("---------------->>> In Before avice: => "+jp.getSignature().toShortString());
		myLogger.info("Arguments \n");
		Object[] args = jp.getArgs();
		for(Object arg : args)
			myLogger.info(arg.toString());
	}
	
	

}
