package kh.spring.myboard.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class AdviceLog {

	@Pointcut("execution(public * kh.spring.myboard..*Dao.*(..))")
	public void commonDaoPointCut() {}
	@Pointcut("execution(public * kh.spring.myboard..*Service.*(..))")
	public void commonServicePointCut() {}
	@Pointcut("execution(public * kh.spring.myboard..*Controller.*(..))")
	public void commonControllerPointCut() {}
	
	@Around("commonDaoPointCut()")
	public Object aroundLogMethod(ProceedingJoinPoint pjp) throws Throwable {
		Object ro = null;  // 타겟메소드로부터 return 받은 값을 저장
		
		System.out.println("\t\t[ " + pjp.getThis() + " : " + pjp.getSignature().getName() + " ]");
		// 타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i = 0; i < args.length; i++) {
			System.out.print("\t\t--args["+i+"] "+args[i] +"\n");
		}	
		
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		// 타겟메소드 실행
		ro = pjp.proceed();
		stopWatch.stop();
		
		
		// 타겟메소드의 return 값
		System.out.println("\t\t[ DAO Ret : " + stopWatch.getTotalTimeMillis() + "ms ] " + ro);
		
		return ro;
	}
	
	@Around("commonControllerPointCut()")
	public Object aroundLogCtrlMethod(ProceedingJoinPoint pjp) throws Throwable {
		Object ro = null;  // 타겟메소드로부터 return 받은 값을 저장
		
		System.out.println("\t[ " + pjp.getThis() + " : " + pjp.getSignature().getName() + " ]");
		// 타겟메소드로 전달되는 매개인자들
		Object[] args = pjp.getArgs();
		for(int i = 0; i < args.length; i++) {
			System.out.print("\t-args[ "+i+" ] "+args[i] +"\n");
		}	
		
		// 타겟메소드 실행
		ro = pjp.proceed();
		
		// 타겟메소드의 return 값
		System.out.println("\t[ CTRL Ret ] "+ ro);
		
		return ro;
	}
	
}
