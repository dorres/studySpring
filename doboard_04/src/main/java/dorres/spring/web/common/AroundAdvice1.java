package dorres.spring.web.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class AroundAdvice1 {
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
		String method = joinPoint.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object returnObj = joinPoint.proceed();
		stopWatch.stop();
		System.out.println(method + "() 메서드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		return returnObj;
	}
}
//<bean id="around" class="dorres.spring.web.common.AroundAdvice1"></bean>
//<aop:config>
//	<aop:pointcut expression="execution(* dorres.spring.web..*Impl.*(..))" id="allPointcut"/>
//	<aop:pointcut expression="execution(* tommy.spring.web..*Impl.get*(..))" id="getPointcut"/>
//	<aop:aspect ref="around">
//		<aop:around method="aroundLog" pointcut-ref="allPointcut"/>
//		<aop:around method="aroundLog" pointcut-ref="getPointcut"/>
//	</aop:aspect>
//</aop:config>